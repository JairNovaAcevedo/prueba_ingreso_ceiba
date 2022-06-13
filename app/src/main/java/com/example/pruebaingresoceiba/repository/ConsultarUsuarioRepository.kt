package com.example.pruebaingresoceiba.repository

import android.app.Application
import androidx.room.Room
import com.example.pruebaingresoceiba.Interfaces.APIService
import com.example.pruebaingresoceiba.Interfaces.InterfaceConsultarUsuario
import com.example.pruebaingresoceiba.data.dataBase.AppDataBase
import com.example.pruebaingresoceiba.data.dataBase.entities.AddressEntity
import com.example.pruebaingresoceiba.data.dataBase.entities.CompanyEntity
import com.example.pruebaingresoceiba.data.dataBase.entities.GeoEntity
import com.example.pruebaingresoceiba.data.dataBase.entities.UsuarioEntity
import com.example.pruebaingresoceiba.data.modelo.UserDataItemResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

class ConsultarUsuarioRepository : InterfaceConsultarUsuario.Repository {

    private var presenter: InterfaceConsultarUsuario.Presenter
    private lateinit var datab: AppDataBase

    constructor(presenter: InterfaceConsultarUsuario.Presenter, application: Application) {
        this.presenter = presenter
        datab = Room.databaseBuilder(
            application, AppDataBase::class.java, AppDataBase.DATABASE_NAME
        ).allowMainThreadQueries()
            .build()
    }

    override fun consultarUsuarioRepository() {
        CoroutineScope(Dispatchers.IO).launch {

            val apiService: APIService = getRetrofit().create(APIService::class.java)
            val callRespuesta: Call<List<UserDataItemResponse>> = apiService.getUserData("users")

            callRespuesta.enqueue(object : Callback<List<UserDataItemResponse>> {
                override fun onResponse(
                    call: Call<List<UserDataItemResponse>>,
                    response: Response<List<UserDataItemResponse>>
                ) {
                    var usuario: List<UserDataItemResponse>? = response.body()
                    if (usuario != null) {
                        guardarBD(usuario)
                    } else {
                        presenter.errorConsultarUsuario("Error")
                    }
                }

                override fun onFailure(call: Call<List<UserDataItemResponse>>, t: Throwable) {
                    println("Filtro - Error en el servidor " + t.message)
                    presenter.errorConsultarUsuario("Error en el servidor " + t.message)
                }
            })
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun guardarBD(datosUsuario: List<UserDataItemResponse>) {

        val geo = ArrayList<GeoEntity>()
        val company = ArrayList<CompanyEntity>()
        val address = ArrayList<AddressEntity>()
        val usuaros = ArrayList<UsuarioEntity>()

        for (dato in datosUsuario) {
            println("the element is $dato")
            geo.add(getGeo(dato))
            company.add(getCompany(dato))
            address.add(getAddress(dato))
            usuaros.add(getUsuario(dato))

        }
        datab.geoDao().insertGeo(geo)
        datab.companyDao().insertCompany(company)
        datab.addressDao().insertAddress(address)
        datab.usuarioDao().insertUsuario(usuaros)

        presenter.respuestaConsultarUsuario(datosUsuario)
    }

    private fun getGeo(dato: UserDataItemResponse): GeoEntity {
        return GeoEntity(
            id = dato.id.toInt(),
            lat = dato.address.geo.lat,
            lng = dato.address.geo.lng
        )
    }

    private fun getCompany(dato: UserDataItemResponse): CompanyEntity {
        return CompanyEntity(
            id = dato.id.toInt(),
            name = dato.company.name,
            catchPhrase = dato.company.catchPhrase,
            bs = dato.company.bs
        )
    }

    private fun getAddress(dato: UserDataItemResponse): AddressEntity {
        return AddressEntity(
            id = dato.id.toInt(),
            street = dato.address.street,
            suite = dato.address.suite,
            city = dato.address.city,
            zipcode = dato.address.zipcode,
            geo = dato.id.toInt()
        )
    }

    private fun getUsuario(dato: UserDataItemResponse): UsuarioEntity {
        return UsuarioEntity(
            id = dato.id.toInt(),
            name = dato.name,
            username = dato.username,
            email = dato.email,
            address = dato.id.toInt(),
            phone = dato.phone,
            website = dato.website,
            company = dato.id.toInt()
        )
    }
}