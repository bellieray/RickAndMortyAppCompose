package com.ebelli.datasource.remote

import com.ebelli.model.CharacterResponse
import com.ebelli.result.NetworkResult
import com.ebelli.result.networkCall
import com.ebelli.retrofit.RickyAndMortyService
import javax.inject.Inject

class CharacterRemoteDataSourceImpl @Inject constructor(private val rickyAndMortyService: RickyAndMortyService) :
    CharacterRemoteDataSource {
    override suspend fun getAllCharacters(pageNumber: Int): NetworkResult<CharacterResponse> {
        return networkCall { rickyAndMortyService.getAllCharacters(pageNumber) }
    }

    override suspend fun getCharactersById(ids: List<String>): NetworkResult<List<com.ebelli.model.Character>>  = networkCall { rickyAndMortyService.getCharactersById(ids) }
}