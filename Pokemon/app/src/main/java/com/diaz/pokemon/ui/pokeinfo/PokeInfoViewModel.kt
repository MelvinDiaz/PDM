package com.diaz.pokemon.ui.pokeinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diaz.pokemon.model.Pokemon
import com.diaz.pokemon.service.PokeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokeInfoViewModel(): ViewModel() {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: PokeApiService = retrofit.create(PokeApiService::class.java)

    val pokemonInfo = MutableLiveData<Pokemon>()

    fun getPokemonInfo(id: Int){
        val call = service.getPokemonInfo(id)

        call.enqueue(object : retrofit2.Callback<Pokemon>{
            override fun onResponse(call: retrofit2.Call<Pokemon>, response: retrofit2.Response<Pokemon>) {
                response.body()?.let { pokemon ->
                    pokemonInfo.postValue(pokemon)
                }
            }

            override fun onFailure(call: retrofit2.Call<Pokemon>, t: Throwable) {
                call.cancel()
            }

        })
    }
}