package com.ebelli.usecase.favorite

import com.ebelli.result.NetworkResult

interface AddToFavoriteUseCase {
    suspend operator fun invoke(character: com.ebelli.model.Character): NetworkResult<Unit>
}