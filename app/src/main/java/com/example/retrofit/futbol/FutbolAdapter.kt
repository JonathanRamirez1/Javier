package com.example.retrofit.futbol

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import kotlinx.android.synthetic.main.item_list_jugadores.view.*

class FutbolAdapter(var scorers : ArrayList<Jugadores>): RecyclerView.Adapter<FutbolAdapter.FutbolViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FutbolViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FutbolViewHolder(layoutInflater.inflate(R.layout.item_list_jugadores, parent, false))

    }

    override fun getItemCount(): Int {
        return scorers.size

    }

    override fun onBindViewHolder(holder: FutbolViewHolder, position: Int) {
        holder.bindJugadores(scorers[position])
    }

    class FutbolViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindJugadores(jugadores: Jugadores) {
            itemView.tvName.text = jugadores.name
            itemView.tvFirtsName.text = jugadores.plan
        }

    }
}