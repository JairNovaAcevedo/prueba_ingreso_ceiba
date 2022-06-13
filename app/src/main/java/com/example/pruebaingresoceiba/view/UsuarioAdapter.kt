package com.example.pruebaingresoceiba.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebaingresoceiba.R
import com.example.pruebaingresoceiba.data.modelo.UserDataItemResponse

class UsuarioAdapter (val datosUsuario:List<UserDataItemResponse>): RecyclerView.Adapter<UsuarioViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UsuarioViewHolder(layoutInflater.inflate(R.layout.item_usuario,parent,false))
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val item = datosUsuario[position]
        holder.bind(item.name,item.phone,item.email)
    }

    override fun getItemCount(): Int = datosUsuario.size

}