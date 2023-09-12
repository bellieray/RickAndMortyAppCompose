package com.ebelli.di

import com.ebelli.repository.Favorite.FavoriteRepository
import com.ebelli.repository.character.CharacterRepository
import com.ebelli.usecase.character.GetCharacterUseCase
import com.ebelli.usecase.character.GetCharacterUseCaseImpl
import com.ebelli.usecase.favorite.*
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
    fun provideGetAllCharactersUseCase(characterRepository: CharacterRepository): GetCharacterUseCase {
        return GetCharacterUseCaseImpl(characterRepository)
    }

    @Provides
    @Singleton
    fun provideAddToFavoritesUseCase(favoriteRepository: FavoriteRepository): AddToFavoriteUseCase {
        return AddToFavoriteUseCaseImpl(favoriteRepository)
    }

    @Provides
    @Singleton
    fun providesRemoveFromFavoritesUseCase(favoriteRepository: FavoriteRepository): RemoveFromFavoriteUseCase {
        return RemoveFromFavoriteUseCaseImpl(favoriteRepository)
    }

    @Provides
    @Singleton
    fun providesGetAllFavoritesUseCase(favoriteRepository: FavoriteRepository): GetAllFavoritesUseCase {
        return GetAllFavoritesUseCaseImpl(favoriteRepository)
    }
}