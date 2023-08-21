package com.ebelli.di

import com.ebelli.datasource.CharacterRemoteDataSource
import com.ebelli.repository.character.CharacterRepository
import com.ebelli.repository.character.CharacterRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
   abstract fun bindsCharacterRepository(characterRepositoryImpl: CharacterRepositoryImpl) : CharacterRepository
}