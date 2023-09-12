package com.ebelli.di

import com.ebelli.datasource.local.FavoriteLocalDataSource
import com.ebelli.datasource.remote.CharacterRemoteDataSource
import com.ebelli.repository.Favorite.FavoriteRepository
import com.ebelli.repository.Favorite.FavoriteRepositoryImpl
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
    fun bindCharacterRepository(characterRemoteDataSource: CharacterRemoteDataSource): CharacterRepository {
        return CharacterRepositoryImpl(characterRemoteDataSource)
    }

    @Provides
    @Singleton
    fun bindFavoriteRepository(favoriteLocalDataSource: FavoriteLocalDataSource): FavoriteRepository {
        return FavoriteRepositoryImpl(favoriteLocalDataSource)
    }
}