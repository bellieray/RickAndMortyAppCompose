package com.ebelli.repository

import android.location.Location
import kotlinx.coroutines.flow.Flow

class CharacterRepositoryImpl: CharacterRepository {
    override suspend fun getLocations(pageNumber: Int): Flow<Location> {
        TODO("Not yet implemented")
    }
}