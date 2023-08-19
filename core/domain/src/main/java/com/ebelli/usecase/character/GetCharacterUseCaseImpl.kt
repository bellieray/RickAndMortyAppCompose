package com.ebelli.usecase.character
import com.ebelli.repository.character.CharacterRepository
import javax.inject.Inject

class GetCharacterUseCaseImpl @Inject constructor(private val characterRepository: CharacterRepository) : GetCharacterUseCase {
    override suspend fun invoke(pageNumber: Int) = characterRepository.getAllCharacters(pageNumber)
}