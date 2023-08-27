package com.ebelli.repository.character

import com.ebelli.model.CharacterResponse
import com.ebelli.result.NetworkResult
import kotlinx.coroutines.flow.Flow
import org.w3c.dom.CharacterData

interface CharacterRepository {
    suspend fun getAllCharacters(pageNumber: Int): Flow<NetworkResult<CharacterResponse>>
}