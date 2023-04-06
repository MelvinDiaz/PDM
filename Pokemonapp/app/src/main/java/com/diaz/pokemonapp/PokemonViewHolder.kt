package com.diaz.pokemonapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.diaz.pokemonapp.databinding.PokemonCardBinding

class PokemonViewHolder(view : View,  private val listener: (String) -> Unit) : RecyclerView.ViewHolder(view){
   private val binding = PokemonCardBinding.bind(view)

    fun bind(pokemon: String){
        binding.pokemonName.text = pokemon
        binding.root.setOnClickListener{listener(pokemon)}
    }
}