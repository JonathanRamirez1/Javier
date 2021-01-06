package com.example.recyclerviewadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewadapter.Adapter.HeroAdapter
import com.example.recyclerviewadapter.Clases.MainHero
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var mainHero: List<MainHero> = listOf (
        MainHero("Asta", "Reino del Trebol", "Grimorio de 5 Hojas", R.drawable.asta, R.drawable.griasta),
        MainHero("Yuno", "Reino del Trebol", "Grimorio de 4 Hojas", R.drawable.yuno, R.drawable.griyuno),
        MainHero("Noelle Silva", "Reino del Trebol", "Grimorio de 3 Hojas", R.drawable.noelle, R.drawable.grinoelle),
        MainHero("Fuegoleon Vermillion", "Reino del Trebol", "Grimorio de 3 Hojas", R.drawable.fuegoleon, R.drawable.grifuego),
        MainHero("Zagred", "Reino de los Demonios", "Grimorio de 5 Hojas", R.drawable.demonio, R.drawable.grizagred),
        MainHero("Dante Zogratis", "Reino de la Pica", "Grimorio de 5 Hojas", R.drawable.dante, R.drawable.gridantet),
        MainHero("Zenon Zogratis", "Reino de la Pica", "Grimorio de 5 Hojas", R.drawable.zenon, R.drawable.grizenon),
        MainHero("Vanika Zogratis", "Reino de la Pica", "Grimorio de 5 Hojas", R.drawable.vanika, R.drawable.grivanikaf)


    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycler()
    }

    fun initRecycler() {
        RecyclerViewHero.layoutManager = LinearLayoutManager(this)
        val heroAdapter = HeroAdapter(mainHero)
        RecyclerViewHero.adapter = heroAdapter

    }
}