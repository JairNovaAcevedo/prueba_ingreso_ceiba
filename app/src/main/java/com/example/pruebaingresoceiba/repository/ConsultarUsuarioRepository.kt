package com.example.pruebaingresoceiba.repository

import com.example.pruebaingresoceiba.Interfaces.APIService
import com.example.pruebaingresoceiba.Interfaces.InterfaceConsultarUsuario
import com.example.pruebaingresoceiba.modelo.UserDataCollection
import com.example.pruebaingresoceiba.modelo.UserDataItemResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConsultarUsuarioRepository: InterfaceConsultarUsuario.Repository {

    var presenter: InterfaceConsultarUsuario.Presenter

    constructor(presenter: InterfaceConsultarUsuario.Presenter){
        this.presenter=presenter
    }

    override fun consultarUsuarioRepository() {
        CoroutineScope(Dispatchers.IO).launch {

            val apiService: APIService = getRetrofit().create(APIService::class.java)
            val callRespuesta: Call<List<UserDataItemResponse>> = apiService.getUserData("users")

            callRespuesta.enqueue(object : Callback<List<UserDataItemResponse>>{
                override fun onResponse(
                    call: Call<List<UserDataItemResponse>>,
                    response: Response<List<UserDataItemResponse>>
                ) {
                    var usuario: List<UserDataItemResponse>? = response.body()
                    if (usuario != null) {
                        presenter.respuestaConsultarUsuario(usuario)
                    } else{
                        presenter.errorConsultarUsuario("Error")
                    }
                }

                override fun onFailure(call: Call<List<UserDataItemResponse>>, t: Throwable) {
                    println("Filtro - Error en el servidor "+t.message)
                    presenter.errorConsultarUsuario("Error en el servidor "+t.message)
                }
            })
        }
    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}