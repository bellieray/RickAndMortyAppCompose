package com.ebelli.usecase.character

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface GetCharacterUseCase {
    suspend operator fun invoke(): Flow<PagingData<com.ebelli.model.Character>>
}