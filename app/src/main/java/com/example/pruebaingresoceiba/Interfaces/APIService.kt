package com.example.pruebaingresoceiba.Interfaces

import com.example.pruebaingresoceiba.modelo.UserDataItemResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET()
    fun getUserData(@Url url:String):Call<List<UserDataItemResponse>>
}