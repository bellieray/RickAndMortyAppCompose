package com.ebelli.datasource.remote

import com.ebelli.model.CharacterResponse
import com.ebelli.result.NetworkResult

interface CharacterRemoteDataSource {
    suspend fun getAllCharacters(pageNumber: Int): NetworkResult<CharacterResponse>
}