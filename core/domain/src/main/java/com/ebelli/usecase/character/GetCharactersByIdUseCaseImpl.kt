package com.ebelli.usecase.character

import com.ebelli.model.CharacterResponse
import com.ebelli.repository.character.CharacterRepository
import com.ebelli.result.NetworkResult

class GetCharactersByIdUseCaseImpl(private val characterRepository: CharacterRepository) : GetCharactersByIdUseCase {
    override suspend fun invoke(ids: List<String>): NetworkResult<List<com.ebelli.model.Character>>  = characterRepository.getCharactersById(ids)
}