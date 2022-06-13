package com.example.pruebaingresoceiba.data.dataBase.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "usuario",
    foreignKeys = [ForeignKey(
        entity = AddressEntity::class,
        parentColumns = ["idaddress"],
        childColumns = ["idaddress"]
    )
    ]
)
data class UsuarioEntity(

    @PrimaryKey
    @ColumnInfo(name = "idusuario")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "username")
    var username: String,

    @ColumnInfo(name = "email")
    var email: String,

    @ColumnInfo(name = "idaddress")
    var address: Int,

    @ColumnInfo(name = "phone")
    var phone: String,

    @ColumnInfo(name = "website")
    var website: String,

    @ColumnInfo(name = "idcompany")
    var company: Int
)