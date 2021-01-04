package com.example.retrofit.`class`

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import kotlinx.android.synthetic.main.item_list_tiempo.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class TiempoAdapter(val metereologia: ArrayList<Tiempo>): RecyclerView.Adapter<TiempoAdapter.TiempoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TiempoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TiempoViewHolder(layoutInflater.inflate(R.layout.item_list_tiempo, parent, false))

    }

    override fun getItemCount(): Int {
       return metereologia.size
    }

    override fun onBindViewHolder(holder: TiempoViewHolder, position: Int) {
        holder.bindTiempo(metereologia[position])

    }

    class TiempoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindTiempo(tiempo: Tiempo) {
            var date = Date(tiempo.dt.toLong()*1000)
            var sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            var tiempo1 = sdf.format(date)
            Log.d("TAG TiempoAdapter: ", tiempo1)

            itemView.tvListaFecha.text = tiempo1
            itemView.tvListaHumedad.text = tiempo.main.humidity
            itemView.tvListaTemperatura.text = tiempo.main.temp
        }

    }

}