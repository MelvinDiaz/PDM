package com.diaz.pokemon.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PokeApiResponse {
    //This is the response from the API
    @Expose @SerializedName("count") val count: Int = 0
    @Expose @SerializedName("next") val next: String = ""
    @Expose @SerializedName("previous") val previous: String = ""
    @Expose @SerializedName("results") val results: List<PokeResult> = emptyList()
}
//This is the inside of the response that the api gave
class PokeResult {
    @Expose @SerializedName("name") val name: String = ""
    @Expose @SerializedName("url") val url: String = ""
}