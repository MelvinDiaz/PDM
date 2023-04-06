package com.diaz.retrofitpractica

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIservice {
    @GET
    suspend fun getDogImage(@Url url:String): Response<DogResponse>
}