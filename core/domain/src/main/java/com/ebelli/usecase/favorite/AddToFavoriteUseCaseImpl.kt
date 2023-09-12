package com.ebelli.usecase.favorite

import com.ebelli.repository.Favorite.FavoriteRepository
import com.ebelli.result.NetworkResult
import javax.inject.Inject

class AddToFavoriteUseCaseImpl @Inject constructor(val favoriteRepository: FavoriteRepository) : AddToFavoriteUseCase {
    override suspend fun invoke(character: com.ebelli.model.Character): NetworkResult<Unit>  = favoriteRepository.addToFavorite(character)

}