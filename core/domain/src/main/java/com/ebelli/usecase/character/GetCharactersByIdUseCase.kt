package com.ebelli.usecase.character

import com.ebelli.model.CharacterResponse
import com.ebelli.result.NetworkResult


interface GetCharactersByIdUseCase {
    suspend operator fun invoke(ids: List<String>): NetworkResult<List<com.ebelli.model.Character>>
}