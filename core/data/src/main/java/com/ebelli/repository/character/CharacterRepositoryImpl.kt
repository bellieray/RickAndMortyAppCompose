package com.ebelli.repository.character

import com.ebelli.datasource.CharacterRemoteDataSource
import com.ebelli.model.CharacterResponse
import com.ebelli.repository.character.CharacterRepository
import com.ebelli.result.NetworkResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

private const val PAGE_SIZE = 20

class CharacterRepositoryImpl @Inject constructor(private val characterRemoteDataSource: CharacterRemoteDataSource) :
    CharacterRepository {
    override suspend fun getAllCharacters(pageNumber: Int): NetworkResult<CharacterResponse> =
        characterRemoteDataSource.getAllCharacters(pageNumber)
}