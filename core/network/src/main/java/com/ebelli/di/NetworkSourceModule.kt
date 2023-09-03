package com.ebelli.di

import com.ebelli.datasource.CharacterRemoteDataSource
import com.ebelli.datasource.CharacterRemoteDataSourceImpl
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
    fun bindsCharacterNetworkDataSource(service: RickyAndMortyService): CharacterRemoteDataSource {
        return CharacterRemoteDataSourceImpl(service)
    }
}