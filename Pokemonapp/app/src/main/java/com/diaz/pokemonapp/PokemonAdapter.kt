package com.diaz.pokemonapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diaz.pokemonapp.databinding.PokemonCardBinding

class PokemonAdapter(
    private var pokemonList: List<String>,
    private var listener: (String) -> Unit
) :
    RecyclerView.Adapter<PokemonViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PokemonCardBinding.inflate(inflater, parent, false)
        return PokemonViewHolder(binding.root, listener)

    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item = pokemonList[position]
        holder.bind(item)
    }

    fun updateList(newList: List<String>) {
        pokemonList = newList
        this.listener = listener
        notifyDataSetChanged()
    }
}