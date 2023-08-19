package com.ebelli.repository.character

import com.ebelli.datasource.CharacterRemoteDataSource
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val characterRemoteDataSource: CharacterRemoteDataSource) :
    CharacterRepository {
    override suspend fun getAllCharacters(pageNumber: Int) =
        characterRemoteDataSource.getAllCharacters(pageNumber)
}