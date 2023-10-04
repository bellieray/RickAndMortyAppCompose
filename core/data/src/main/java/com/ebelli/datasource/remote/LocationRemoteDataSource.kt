package com.ebelli.datasource.remote

import com.ebelli.model.LocationInfo
import com.ebelli.result.NetworkResult

interface LocationRemoteDataSource {
    suspend fun getLocations() : NetworkResult<LocationInfo>
}