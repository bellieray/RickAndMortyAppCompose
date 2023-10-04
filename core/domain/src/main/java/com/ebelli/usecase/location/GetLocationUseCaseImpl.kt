package com.ebelli.usecase.location

import com.ebelli.model.LocationInfo
import com.ebelli.repository.location.LocationRepository
import com.ebelli.result.NetworkResult
import javax.inject.Inject

class GetLocationUseCaseImpl @Inject constructor(private val locationRepository: LocationRepository) :
    GetLocationsUseCase {
    override suspend fun invoke(): NetworkResult<LocationInfo> = locationRepository.getLocations()

}