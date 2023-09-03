package com.ebelli.datasource

import com.ebelli.model.CharacterResponse
import com.ebelli.result.NetworkResult
import com.ebelli.result.apiCall
import com.ebelli.retrofit.RickyAndMortyService
import javax.inject.Inject

class CharacterRemoteDataSourceImpl @Inject constructor(private val rickyAndMortyService: RickyAndMortyService) :
    CharacterRemoteDataSource {
    override suspend fun getAllCharacters(pageNumber: Int): NetworkResult<CharacterResponse> {
        return apiCall { rickyAndMortyService.getAllCharacters(pageNumber) }
    }
}