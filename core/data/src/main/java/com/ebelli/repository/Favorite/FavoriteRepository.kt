package com.ebelli.repository.Favorite

import com.ebelli.model.Character
import com.ebelli.result.NetworkResult
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    suspend fun addToFavorite(character: Character): NetworkResult<Unit>
    suspend fun removeFromFavorites(character: Character): NetworkResult<Unit>
    suspend fun getAllFavorites(): Flow<NetworkResult<List<Character>>>

}