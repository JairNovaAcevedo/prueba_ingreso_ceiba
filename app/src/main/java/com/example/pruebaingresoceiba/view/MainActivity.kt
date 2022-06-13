package com.example.pruebaingresoceiba.view

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.pruebaingresoceiba.Interfaces.InterfaceConsultarUsuario
import com.example.pruebaingresoceiba.data.dataBase.AppDataBase
import com.example.pruebaingresoceiba.databinding.ActivityMainBinding
import com.example.pruebaingresoceiba.data.modelo.UserDataItemResponse
import com.example.pruebaingresoceiba.presenter.ConsultarUsuariosPresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), InterfaceConsultarUsuario.View {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UsuarioAdapter
    private val datosUsuario = mutableListOf<UserDataItemResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        eventoBuscarDato()
        initRecyclerView()
        var presenter: InterfaceConsultarUsuario.Presenter =
            ConsultarUsuariosPresenter(this, application)
        presenter.consultarUsuario()
    }

    private fun eventoBuscarDato() {
        binding.buscarDatosEdt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                var dato = binding.buscarDatosEdt.text.trim()
                println("El caracter escrito es: $dato")
            }

        })
    }

    private fun initRecyclerView() {
        adapter = UsuarioAdapter(datosUsuario)
        binding.recyclerListaUsuarios.layoutManager = LinearLayoutManager(this)
        binding.recyclerListaUsuarios.adapter = adapter
    }

    override fun respuestaConsultarUsuario(datosUsuario: List<UserDataItemResponse>) {
        println("Filtro - respuestaConsultarUsuario")
        this.datosUsuario.clear()
        this.datosUsuario.addAll(datosUsuario)
        this.adapter.notifyDataSetChanged()
    }

    override fun errorConsultarUsuario(respuesta: String) {
        Toast.makeText(this, respuesta, Toast.LENGTH_LONG).show()
    }

}