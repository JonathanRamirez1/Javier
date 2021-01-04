package com.example.retrofit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit.R
import com.example.retrofit.`class`.ApiTiempo
import com.example.retrofit.`class`.Metereologia
import com.example.retrofit.`class`.Tiempo
import com.example.retrofit.`class`.TiempoAdapter
import kotlinx.android.synthetic.main.activity_tiempo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TiempoActivity : AppCompatActivity() {

    val URLAPI = "https://samples.openweathermap.org/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiempo)

        tiempoActivityRecyclerView.layoutManager = LinearLayoutManager(this)
        tiempoActivityRecyclerView.adapter = null

        var retrofitTiempo = Retrofit.Builder()
            .baseUrl(URLAPI)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var apiTiempo = retrofitTiempo.create(ApiTiempo::class.java)
        var callTiempo = apiTiempo.getTiempo()
        callTiempo.enqueue(object : Callback<Metereologia> {
            override fun onFailure(call: Call<Metereologia>, t: Throwable?) {
                Log.e("TAG Fallo: ", t.toString())
            }

            override fun onResponse(call: Call<Metereologia>, response: Response<Metereologia>) {
                for (res in response.body()!!.list) {
                    Log.d("TAG Respuesta: ", res.main.temp)
                }
                tiempoActivityRecyclerView.adapter = TiempoAdapter(response.body()!!.list)
            }

        } )
    }
}