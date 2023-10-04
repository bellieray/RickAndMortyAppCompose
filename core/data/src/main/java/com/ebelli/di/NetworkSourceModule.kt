package com.ebelli.di

import com.ebelli.dao.CharacterDao
import com.ebelli.datasource.local.FavoriteLocalDataSource
import com.ebelli.datasource.local.FavoriteLocalDataSourceImpl
import com.ebelli.datasource.remote.CharacterRemoteDataSource
import com.ebelli.datasource.remote.CharacterRemoteDataSourceImpl
import com.ebelli.datasource.remote.LocationRemoteDataSource
import com.ebelli.datasource.remote.LocationRemoteDataSourceImpl
import com.ebelli.retrofit.RickyAndMortyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkSourceModule {
    @Provides
    @Singleton
    fun provideCharacterNetworkDataSource(service: RickyAndMortyService): CharacterRemoteDataSource {
        return CharacterRemoteDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideFavoriteDataSource(characterDao: CharacterDao): FavoriteLocalDataSource {
        return FavoriteLocalDataSourceImpl(characterDao)
    }

    @Provides
    @Singleton
    fun provideLocationDataSource(service: RickyAndMortyService): LocationRemoteDataSource {
        return LocationRemoteDataSourceImpl(service)
    }
}