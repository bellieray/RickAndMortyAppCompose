package com.ebelli.usecase

import android.location.Location
import kotlinx.coroutines.flow.Flow

interface GetCharacterUseCase {
    suspend operator fun invoke(pageNumber: Int): Flow<Location>
}