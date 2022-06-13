package com.example.pruebaingresoceiba.data.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebaingresoceiba.data.dataBase.entities.CompanyEntity

@Dao
interface CompanyDao {

    @Query("SELECT * FROM company")
    fun getAllCompany(): List<CompanyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCompany(persona: List<CompanyEntity>)
}