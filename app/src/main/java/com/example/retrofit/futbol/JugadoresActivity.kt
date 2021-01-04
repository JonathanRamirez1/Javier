package com.example.retrofit.futbol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.R
import kotlinx.android.synthetic.main.activity_jugadores.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JugadoresActivity : AppCompatActivity() {

    val URLAPI = "http://api.football-data.org/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jugadores)

        jugadoresActivityRecyclerView.layoutManager = LinearLayoutManager(this)
        jugadoresActivityRecyclerView.adapter = null

        var retrofitJugadores = Retrofit.Builder()
            .baseUrl(URLAPI)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var apiJugadores = retrofitJugadores.create(ApiJugadores::class.java)
        var callJugadores = apiJugadores.getJugadores()
        callJugadores.enqueue(object : Callback<Nombres> {
            override fun onFailure(call: Call<Nombres>, t: Throwable?) {
                Log.e("TAG FALLO: ", t.toString())
            }

            override fun onResponse(call: Call<Nombres>, response: Response<Nombres>) {
                for (res in response.body()!!.competitions)
                    Log.d("Respuesta: ", res.name + res.plan)

                jugadoresActivityRecyclerView.adapter = FutbolAdapter(response.body()!!.competitions)
            }

        })
    }
}