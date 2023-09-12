package com.ebelli.usecase.favorite

import com.ebelli.model.Character
import com.ebelli.repository.Favorite.FavoriteRepository
import com.ebelli.result.NetworkResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllFavoritesUseCaseImpl @Inject constructor(private val favoriteRepository: FavoriteRepository) :
    GetAllFavoritesUseCase {
    override suspend fun invoke(): Flow<NetworkResult<List<Character>>> =
        flow {
            emitAll(favoriteRepository.getAllFavorites())
        }
}