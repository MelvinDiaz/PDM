package com.diaz.retrofitpractica

import com.google.gson.annotations.SerializedName

data class DogResponse(
    @SerializedName("message") var images: List<String>,
    @SerializedName("status") var status: String
)