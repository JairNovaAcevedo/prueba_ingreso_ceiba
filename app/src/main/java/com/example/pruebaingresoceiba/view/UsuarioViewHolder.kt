package com.example.pruebaingresoceiba.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebaingresoceiba.databinding.ItemUsuarioBinding

class UsuarioViewHolder(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemUsuarioBinding.bind(view)

    fun bind(titulo:String, telefono:String, correo:String){
        binding.titulo.text = titulo
        binding.telefono.text = telefono
        binding.correo.text = correo
    }
}