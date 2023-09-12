package com.ebelli.usecase.favorite

import com.ebelli.model.Character
import com.ebelli.result.NetworkResult
import kotlinx.coroutines.flow.Flow

interface GetAllFavoritesUseCase{
    suspend operator fun invoke(): Flow<NetworkResult<List<Character>>>

}