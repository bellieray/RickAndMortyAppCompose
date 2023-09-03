package com.ebelli.di

import com.ebelli.datasource.CharacterRemoteDataSource
import com.ebelli.repository.character.CharacterRepository
import com.ebelli.repository.character.CharacterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun bindsCharacterRepository(characterRemoteDataSource: CharacterRemoteDataSource): CharacterRepository {
        return CharacterRepositoryImpl(characterRemoteDataSource)
    }
}