package com.example.retrofit.futbol

import retrofit2.Call
import retrofit2.http.GET

interface ApiJugadores {

    @GET ("v2/competitions")
    abstract fun getJugadores(): Call<Nombres>
}