package com.example.pruebaingresoceiba.repository

import com.example.pruebaingresoceiba.Interfaces.InterfaceConsultarUsuario

class ConsultarUsuarioRepository: InterfaceConsultarUsuario.Repository {

    var presenter: InterfaceConsultarUsuario.Presenter

    constructor(presenter: InterfaceConsultarUsuario.Presenter){
        this.presenter=presenter
    }

    override fun consultarUsuarioRepository() {

    }
}