package com.example.pruebaingresoceiba.Interfaces

interface InterfaceConsultarUsuario {

    interface View{
        fun respuestaConsultarUsuario()
    }

    interface Presenter{
        fun consultarUsuario()
        fun respuestaConsultarUsuario()
    }

    interface Repository{
        fun consultarUsuarioRepository()
    }
}