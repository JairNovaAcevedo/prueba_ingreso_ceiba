package com.example.pruebaingresoceiba.data.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebaingresoceiba.data.dataBase.entities.UsuarioEntity

@Dao
interface UsuarioDao {

    @Query("SELECT * FROM usuario")
    fun getAllUsuario():List<UsuarioEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsuario(usuario: List<UsuarioEntity>)
}