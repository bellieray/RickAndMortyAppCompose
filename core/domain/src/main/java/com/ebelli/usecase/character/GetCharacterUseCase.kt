package com.ebelli.usecase.character

import com.ebelli.model.CharacterResponse
import com.ebelli.result.NetworkResult
import kotlinx.coroutines.flow.Flow
import org.w3c.dom.CharacterData

interface GetCharacterUseCase {
    suspend operator fun invoke(pageNumber: Int): Flow<NetworkResult<CharacterResponse>>
}