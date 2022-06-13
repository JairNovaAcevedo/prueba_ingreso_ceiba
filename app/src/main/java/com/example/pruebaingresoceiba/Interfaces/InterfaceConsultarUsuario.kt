package com.example.pruebaingresoceiba.Interfaces

import com.example.pruebaingresoceiba.data.modelo.UserDataItemResponse

interface InterfaceConsultarUsuario {

    interface View{
        fun respuestaConsultarUsuario(datosUsuario:List<UserDataItemResponse>)
        fun errorConsultarUsuario(respuesta: String)
    }

    interface Presenter{
        fun consultarUsuario()
        fun respuestaConsultarUsuario(datosUsuario:List<UserDataItemResponse>)
        fun errorConsultarUsuario(respuesta: String)
    }

    interface Repository{
        fun consultarUsuarioRepository()
    }
}