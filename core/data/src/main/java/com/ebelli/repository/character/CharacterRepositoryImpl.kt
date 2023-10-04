package com.ebelli.repository.character

import com.ebelli.datasource.remote.CharacterRemoteDataSource
import com.ebelli.model.CharacterResponse
import com.ebelli.result.NetworkResult
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val characterRemoteDataSource: CharacterRemoteDataSource) :
    CharacterRepository {
    override suspend fun getAllCharacters(pageNumber: Int): NetworkResult<CharacterResponse> =
        characterRemoteDataSource.getAllCharacters(pageNumber)

    override suspend fun getCharactersById(ids: List<String>): NetworkResult<List<com.ebelli.model.Character>> =
        characterRemoteDataSource.getCharactersById(ids)
}