package com.example.pruebaingresoceiba.data.dataBase.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company")
data class CompanyEntity(

    @PrimaryKey
    @ColumnInfo(name = "idcompany")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "catchPhrase")
    var catchPhrase: String,

    @ColumnInfo(name = "bs")
    var bs: String
)