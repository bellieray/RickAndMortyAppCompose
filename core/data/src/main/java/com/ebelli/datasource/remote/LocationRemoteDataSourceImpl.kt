package com.ebelli.datasource.remote

import com.ebelli.model.Location
import com.ebelli.model.LocationInfo
import com.ebelli.result.NetworkResult
import com.ebelli.result.networkCall
import com.ebelli.retrofit.RickyAndMortyService
import javax.inject.Inject

class LocationRemoteDataSourceImpl @Inject constructor(private val service: RickyAndMortyService) : LocationRemoteDataSource {
    override suspend fun getLocations(): NetworkResult<LocationInfo> = networkCall { service.getLocations(1) }
}