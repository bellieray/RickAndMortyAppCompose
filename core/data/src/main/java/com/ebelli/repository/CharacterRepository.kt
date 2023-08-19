package com.ebelli.repository

import android.location.Location
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {
    suspend fun getLocations(pageNumber: Int): Flow<Location>
}