package com.ebelli.repository.Favorite

import com.ebelli.datasource.local.FavoriteLocalDataSource
import com.ebelli.model.Character
import com.ebelli.result.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(private val favoriteLocalDataSource: FavoriteLocalDataSource) :
    FavoriteRepository {
    override suspend fun addToFavorite(character: Character): NetworkResult<Unit> =
        favoriteLocalDataSource.addToFavorite(character)

    override suspend fun removeFromFavorites(character: Character): NetworkResult<Unit> =
        favoriteLocalDataSource.removeFromFavorites(character)

    override suspend fun getAllFavorites(): Flow<NetworkResult<List<Character>>> = flow {
        emitAll(favoriteLocalDataSource.getAllFavorites())
    }
}