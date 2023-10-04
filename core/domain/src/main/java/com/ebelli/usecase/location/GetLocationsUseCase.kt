package com.ebelli.usecase.location

import com.ebelli.model.LocationInfo
import com.ebelli.result.NetworkResult

interface GetLocationsUseCase {
    suspend operator fun invoke(): NetworkResult<LocationInfo>
}