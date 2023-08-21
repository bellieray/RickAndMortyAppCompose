package com.ebelli.di

import com.ebelli.datasource.CharacterRemoteDataSource
import com.ebelli.datasource.CharacterRemoteDataSourceImpl
import com.ebelli.retrofit.RickyAndMortyService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkSourceModule {
    @Binds
    abstract fun bindsCharacterNetworkDataSource(remoteDataSourceImpl: CharacterRemoteDataSourceImpl) : CharacterRemoteDataSource
}