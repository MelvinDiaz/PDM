package com.diaz.pokemonapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIservice {
    //Aqui serializamos la respuesta de la API
    @GET
    suspend fun getListPokemon(@Url url: String): Response<PokemonResponse>

    @GET()
    suspend fun getPokemon(@Url url: String): Response<Pokemon>
}