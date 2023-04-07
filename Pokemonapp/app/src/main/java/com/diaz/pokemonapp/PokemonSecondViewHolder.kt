package com.diaz.pokemonapp

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.diaz.pokemonapp.databinding.PokemonDetailsBinding


class PokemonSecondViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = PokemonDetailsBinding.bind(view)

    fun bind(pokemon: Pokemon) {
        binding.pokemonName.text = pokemon.name
        binding.pokemonType.text = pokemon.types[0].type.name
    }
}