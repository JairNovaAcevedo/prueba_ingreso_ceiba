package com.example.pruebaingresoceiba.data.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebaingresoceiba.data.dataBase.dao.AddressDao
import com.example.pruebaingresoceiba.data.dataBase.dao.CompanyDao
import com.example.pruebaingresoceiba.data.dataBase.dao.GeoDao
import com.example.pruebaingresoceiba.data.dataBase.dao.UsuarioDao
import com.example.pruebaingresoceiba.data.dataBase.entities.AddressEntity
import com.example.pruebaingresoceiba.data.dataBase.entities.CompanyEntity
import com.example.pruebaingresoceiba.data.dataBase.entities.GeoEntity
import com.example.pruebaingresoceiba.data.dataBase.entities.UsuarioEntity

@Database(
    entities = [UsuarioEntity::class, AddressEntity::class, GeoEntity::class, CompanyEntity::class],
    version = 1,
    exportSchema = true
)
abstract class AppDataBase: RoomDatabase() {

    abstract fun usuarioDao(): UsuarioDao
    abstract fun addressDao(): AddressDao
    abstract fun companyDao(): CompanyDao
    abstract fun geoDao(): GeoDao

    companion object{
        const val DATABASE_NAME = "db_users"
    }
}