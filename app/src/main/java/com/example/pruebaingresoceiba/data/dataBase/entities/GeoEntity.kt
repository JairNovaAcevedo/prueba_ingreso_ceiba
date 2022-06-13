package com.example.pruebaingresoceiba.data.dataBase.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "geo")
data class GeoEntity(

    @PrimaryKey
    @ColumnInfo(name = "idgeo")
    var id: Int,

    @ColumnInfo(name = "lat")
    var lat: String,

    @ColumnInfo(name = "lng")
    var lng: String
)