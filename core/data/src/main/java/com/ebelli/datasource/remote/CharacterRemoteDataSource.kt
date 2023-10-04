package com.ebelli.datasource.remote

import com.ebelli.model.CharacterResponse
import com.ebelli.result.NetworkResult

interface CharacterRemoteDataSource {
    suspend fun getAllCharacters(pageNumber: Int): NetworkResult<CharacterResponse>
    suspend fun getCharactersById(ids: List<String>): NetworkResult<List<com.ebelli.model.Character>>
}