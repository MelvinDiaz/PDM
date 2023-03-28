package com.diaz.recyclerviewejemplo

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerPersonaje(var context: Context, var listaPersonajes:MutableList<Personaje>):
    RecyclerView.Adapter<RecyclerPersonaje.MiHolder>() {

    inner class MiHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var labelNombre: TextView

        init {
            labelNombre = itemView.findViewById(R.id.label_personaje)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiHolder {
    val itemView = LayoutInflater.from(context).inflate(R.layout.carta_personaje, parent, false)
        return MiHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaPersonajes.size
    }

    override fun onBindViewHolder(holder: MiHolder, position: Int) {
        var personaje = listaPersonajes[position]
        holder.labelNombre.text = personaje.nombre
    }

}
