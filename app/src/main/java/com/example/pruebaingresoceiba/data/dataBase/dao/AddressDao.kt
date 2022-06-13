package com.example.pruebaingresoceiba.data.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebaingresoceiba.data.dataBase.entities.AddressEntity

@Dao
interface AddressDao {

    @Query("SELECT * FROM adress")
    fun getAllAddress():List<AddressEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAddress(persona: List<AddressEntity>)
}