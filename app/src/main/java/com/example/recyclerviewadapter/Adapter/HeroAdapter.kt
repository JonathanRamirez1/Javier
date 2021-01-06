package com.example.recyclerviewadapter.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewadapter.Clases.MainHero
import com.example.recyclerviewadapter.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_hero.view.*

class HeroAdapter(val mainHero: List<MainHero>): RecyclerView.Adapter<HeroAdapter.HeroHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroHolder(layoutInflater.inflate(R.layout.item_hero, parent, false) )
    }

    override fun getItemCount(): Int {
        return mainHero.size

    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        holder.render(mainHero[position] )
    }
    class HeroHolder(val view: View): RecyclerView.ViewHolder(view) {

        fun render(mainHero: MainHero) {
            view.tvNombreReal.text = mainHero.NombreReal
            view.tvNombreHero.text = mainHero.NombreHero
            view.tvCategoriaHero.text = mainHero.CategoriaHero
            Picasso.get()
                .load(mainHero.Url)
                .into(view.ivUrl)
            Picasso.get()
                .load(mainHero.Gri)
                .into(view.ivGrimorio)
            view.setOnClickListener {
                Toast.makeText(view.context, "Has seleccionado a: ${mainHero.NombreHero}, ${mainHero.NombreReal}, ${mainHero.CategoriaHero}", Toast.LENGTH_SHORT).show()

            }
        }
    }

}