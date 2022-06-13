package com.example.pruebaingresoceiba.data.dataBase.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "adress",
    foreignKeys = [ForeignKey(
        entity = GeoEntity::class,
        parentColumns = ["idgeo"],
        childColumns = ["idgeo"]
    )
    ]
)
data class AddressEntity(

    @PrimaryKey
    @ColumnInfo(name = "idaddress")
    var id: Int,

    @ColumnInfo(name = "street")
    var street: String,

    @ColumnInfo(name = "suite")
    var suite: String,

    @ColumnInfo(name = "city")
    var city: String,

    @ColumnInfo(name = "zipcode")
    var zipcode: String,

    @ColumnInfo(name = "idgeo")
    var geo: Int
)