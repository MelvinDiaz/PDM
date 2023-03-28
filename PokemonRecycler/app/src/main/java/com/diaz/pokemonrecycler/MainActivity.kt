package com.diaz.pokemonrecycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.diaz.pokemonrecycler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var pokemonList:MutableList<Pokemon> = mutableListOf()
    private lateinit var recyclerPokemon: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pokemonList.add(Pokemon("Bulbasaur", "Grass"))
        pokemonList.add(Pokemon("Charmander", "Fire"))
        pokemonList.add(Pokemon("Squirtle", "Water"))
        pokemonList.add(Pokemon("Pikachu", "Electric"))

        establishAdapter()
    }

    private fun establishAdapter(){
        recyclerPokemon = binding.recyclerPokemon
        recyclerPokemon.layoutManager = LinearLayoutManager(this)
        recyclerPokemon.adapter = RecyclerPokemon(this, pokemonList)
    }

}