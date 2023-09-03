package com.ebelli.di

import com.ebelli.repository.character.CharacterRepository
import com.ebelli.usecase.character.GetCharacterUseCase
import com.ebelli.usecase.character.GetCharacterUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun bindsGetAllCharactersUseCase(characterRepository: CharacterRepository): GetCharacterUseCase {
        return GetCharacterUseCaseImpl(characterRepository)
    }
}