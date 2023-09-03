package com.ebelli.datasource

import androidx.paging.PagingData
import com.ebelli.model.CharacterResponse
import com.ebelli.result.NetworkResult
import kotlinx.coroutines.flow.Flow
import org.w3c.dom.CharacterData

interface CharacterRemoteDataSource {
    suspend fun getAllCharacters(pageNumber : Int): NetworkResult<CharacterResponse>
}