package com.ebelli.retrofit

import android.location.Location
import com.ebelli.model.LocationInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickyAndMortyService {
    @GET("location")
    suspend fun getLocations(@Query("page") pageNumber: Int): Response<LocationInfo>

    @GET("character/{id}")
    suspend fun getCharactersById(@Path("id") id: List<String>): Response<List<com.ebelli.model.Character>>

    @GET("character/")
    suspend fun getAllCharacters(@Query("page") pageNumber: Int): Response<com.ebelli.model.CharacterResponse>
}