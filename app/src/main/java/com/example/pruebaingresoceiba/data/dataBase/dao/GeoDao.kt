package com.example.pruebaingresoceiba.data.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebaingresoceiba.data.dataBase.entities.GeoEntity

@Dao
interface GeoDao {

    @Query("SELECT * FROM geo")
    fun getAllGeo(): List<GeoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertGeo(persona: List<GeoEntity>)
}