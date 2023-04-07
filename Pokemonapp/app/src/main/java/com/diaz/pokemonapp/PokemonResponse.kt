package com.diaz.pokemonapp

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String,
    @SerializedName("results") val results: List<Result>
)

data class Result(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class Pokemon(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("base_experience") val baseExperience: Int,
    @SerializedName("height") val height: Int,
    @SerializedName("Sprites") val sprites: Sprites,
    @SerializedName("types") val types: List<pokemonTypes>,

    )

data class Sprites(
    @SerializedName("front_default") val frontDefault: String,
    @SerializedName("back_default") val backDefault: String,
    @SerializedName("front_shiny") val frontShiny: String,
    @SerializedName("back_shiny") val backShiny: String
)

data class pokemonTypes(
    @SerializedName("type") val type: Type
)

data class Type(
    @SerializedName("name") val name: String
)