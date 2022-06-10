package com.example.pruebaingresoceiba.presenter

import com.example.pruebaingresoceiba.Interfaces.InterfaceConsultarUsuario
import com.example.pruebaingresoceiba.repository.ConsultarUsuarioRepository

class ConsultarUsuariosPresenter : InterfaceConsultarUsuario.Presenter{

    private var view:InterfaceConsultarUsuario.View
    private var repository:InterfaceConsultarUsuario.Repository

    constructor(view: InterfaceConsultarUsuario.View){
        this.view = view
        this.repository = ConsultarUsuarioRepository(this)
    }

    override fun consultarUsuario() {
        repository.consultarUsuarioRepository()
    }

    override fun respuestaConsultarUsuario() {
        view.respuestaConsultarUsuario()
    }

}