package com.diaz.pokemonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.diaz.pokemonapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PokemonAdapter
    private val pokemonList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        showPokemonList("https://pokeapi.co/api/v2/pokemon?limit=1000&offset=0")
    }

    private fun initRecyclerView() {
        adapter = PokemonAdapter(pokemonList)
        binding.pokemonList.layoutManager = LinearLayoutManager(this)
        binding.pokemonList.adapter = adapter
        showPokemonList("")
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun showPokemonList(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIservice::class.java)
                .getListPokemon(query)
            val pokemon = call.body()
            runOnUiThread {
                if (call.isSuccessful) {
                    //Show recycler
                    val pokemon = call.body()?.results?.map { it.name } ?: emptyList()
                    adapter.updateList(pokemon)
                } else {
                    //Show error
                    showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }
}