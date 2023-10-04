package com.ebelli.repository.character

import com.ebelli.model.CharacterResponse
import com.ebelli.result.NetworkResult
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getAllCharacters(pageNumber: Int): NetworkResult<CharacterResponse>
    suspend fun getCharactersById(ids: List<String>): NetworkResult<List<com.ebelli.model.Character>>
}