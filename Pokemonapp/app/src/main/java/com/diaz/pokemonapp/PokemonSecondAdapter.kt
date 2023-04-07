package com.diaz.pokemonapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diaz.pokemonapp.databinding.PokemonDetailsBinding

class PokemonSecondAdapter(private var pokemon: Pokemon?) :
    RecyclerView.Adapter<PokemonSecondViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonSecondViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PokemonDetailsBinding.inflate(inflater, parent, false)
        return PokemonSecondViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return 1
    }


    override fun onBindViewHolder(holder: PokemonSecondViewHolder, position: Int) {
        val item = pokemon
        if (item != null) {
            holder.bind(item)
        }


    }

    //adapter.updateList(emptyList())
    //adapter.updateList(emptyList())
    fun addPokemon(pokemon: Pokemon) {
        this.pokemon = pokemon
        notifyDataSetChanged()
    }

    fun clearList() {
        pokemon = null
        notifyDataSetChanged()
    }
}