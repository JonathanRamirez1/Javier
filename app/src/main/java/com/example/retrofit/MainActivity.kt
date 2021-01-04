package com.example.retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofit.activity.TiempoActivity
import com.example.retrofit.futbol.JugadoresActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityBtApiTiempo.setOnClickListener {
            var intent = Intent(this, TiempoActivity::class.java)
            startActivity(intent)
        }

        mainActivityBtApiJugadores.setOnClickListener {
            var intent = Intent(this, JugadoresActivity::class.java)
            startActivity(intent)
        }

    }
}