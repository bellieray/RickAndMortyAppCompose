package com.ebelli.usecase.favorite

import com.ebelli.repository.Favorite.FavoriteRepository
import com.ebelli.result.NetworkResult
import javax.inject.Inject

class RemoveFromFavoriteUseCaseImpl @Inject constructor(private val favoriteRepository: FavoriteRepository) :
    RemoveFromFavoriteUseCase {
    override suspend fun invoke(character: com.ebelli.model.Character): NetworkResult<Unit> =
        favoriteRepository.removeFromFavorites(character)
}