package com.example.pruebaingresoceiba.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.example.pruebaingresoceiba.Interfaces.InterfaceConsultarUsuario
import com.example.pruebaingresoceiba.R
import com.example.pruebaingresoceiba.databinding.ActivityMainBinding
import com.example.pruebaingresoceiba.presenter.ConsultarUsuariosPresenter

class MainActivity : AppCompatActivity(), InterfaceConsultarUsuario.View {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        eventoBuscarDato()
        var presenter:InterfaceConsultarUsuario.Presenter = ConsultarUsuariosPresenter(this)
        presenter.consultarUsuario()
    }

    private fun eventoBuscarDato(){
        binding.buscarDatosEdt.addTextChangedListener(object : TextWatcher{
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

    override fun respuestaConsultarUsuario() {

    }
}