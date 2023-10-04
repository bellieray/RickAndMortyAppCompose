package com.ebelli.repository.location

import com.ebelli.datasource.remote.LocationRemoteDataSource
import com.ebelli.model.LocationInfo
import com.ebelli.result.NetworkResult
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(val remoteDataSource: LocationRemoteDataSource) :
    LocationRepository {
    override suspend fun getLocations(): NetworkResult<LocationInfo> =
        remoteDataSource.getLocations()
}