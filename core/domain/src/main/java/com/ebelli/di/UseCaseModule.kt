package com.ebelli.di

import com.ebelli.repository.character.CharacterRepository
import com.ebelli.usecase.character.GetCharacterUseCase
import com.ebelli.usecase.character.GetCharacterUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindsGetAllCharactersUseCase(useCaseImpl: GetCharacterUseCaseImpl): GetCharacterUseCase
}