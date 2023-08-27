package com.ebelli.datasource

import com.ebelli.model.CharacterResponse
import com.ebelli.result.NetworkResult
import com.ebelli.result.apiCall
import com.ebelli.retrofit.RickyAndMortyService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.w3c.dom.CharacterData
import javax.inject.Inject

class CharacterRemoteDataSourceImpl @Inject constructor(private val rickyAndMortyService: RickyAndMortyService) :
    CharacterRemoteDataSource {
    override suspend fun getAllCharacters(pageNumber: Int): Flow<NetworkResult<CharacterResponse>> {
        return flow {
            apiCall { rickyAndMortyService.getAllCharacters(pageNumber) }
        }
    }
}