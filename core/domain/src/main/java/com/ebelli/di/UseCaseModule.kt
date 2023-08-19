package com.ebelli.di

import com.ebelli.repository.character.CharacterRepository
import com.ebelli.usecase.character.GetCharacterUseCase
import com.ebelli.usecase.character.GetCharacterUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Binds
    fun bindsGetAllCharactersUseCase(characterRepository: CharacterRepository): GetCharacterUseCase =
        GetCharacterUseCaseImpl(characterRepository)
}