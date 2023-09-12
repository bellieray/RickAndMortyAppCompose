package com.ebelli.repository.character

import com.ebelli.datasource.remote.CharacterRemoteDataSource
import com.ebelli.model.CharacterResponse
import com.ebelli.result.NetworkResult
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val characterRemoteDataSource: CharacterRemoteDataSource) :
    CharacterRepository {
    override suspend fun getAllCharacters(pageNumber: Int): NetworkResult<CharacterResponse> =
        characterRemoteDataSource.getAllCharacters(pageNumber)
}