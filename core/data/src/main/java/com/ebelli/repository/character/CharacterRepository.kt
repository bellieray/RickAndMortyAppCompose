package com.ebelli.repository.character

import com.ebelli.model.CharacterResponse
import com.ebelli.result.NetworkResult
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getAllCharacters(pageNumber: Int): NetworkResult<CharacterResponse>
}