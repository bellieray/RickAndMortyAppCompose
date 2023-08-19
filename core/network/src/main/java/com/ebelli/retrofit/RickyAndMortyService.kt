package com.ebelli.retrofit

import android.location.Location
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickyAndMortyService {
    @GET("location")
    suspend fun getLocations(@Query("page") pageNumber: Int): Response<Location>

    @GET("character/{id}")
    suspend fun getCharactersById(@Path("id") id: List<String>): Response<com.ebelli.model.Character>
}