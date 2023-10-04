package com.ebelli.repository.location

import com.ebelli.model.LocationInfo
import com.ebelli.result.NetworkResult

interface LocationRepository {
    suspend fun getLocations(): NetworkResult<LocationInfo>
}