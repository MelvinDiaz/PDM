package com.diaz.pokemonrecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerPokemon(var context: Context, var pokemonList:MutableList<Pokemon>):
    RecyclerView.Adapter<RecyclerPokemon.MiHolder>() {

    inner class MiHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var labelName: TextView
        lateinit var labelType: TextView

        init {
            labelName = itemView.findViewById(R.id.txt_name)
            labelType = itemView.findViewById(R.id.txt_type)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerPokemon.MiHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.pokemon_layout, parent, false)
        return MiHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerPokemon.MiHolder, position: Int) {
        var pokemon = pokemonList[position]
        holder.labelName.text = pokemon.name
        holder.labelType.text = pokemon.type
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

}