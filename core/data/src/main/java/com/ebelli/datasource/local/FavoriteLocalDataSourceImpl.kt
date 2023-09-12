package com.ebelli.datasource.local

import com.ebelli.dao.CharacterDao
import com.ebelli.model.Character
import com.ebelli.result.NetworkResult
import com.ebelli.result.databaseCall
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FavoriteLocalDataSourceImpl @Inject constructor(private val characterDao: CharacterDao) :
    FavoriteLocalDataSource {
    override suspend fun addToFavorite(character: Character): NetworkResult<Unit> {
        return databaseCall { characterDao.addToFavorites(character) }
    }

    override suspend fun removeFromFavorites(character: Character): NetworkResult<Unit> {
        return databaseCall { characterDao.removeFromFavorites(character.id) }
    }

    override suspend fun getAllFavorites(): Flow<NetworkResult<List<Character>>> {
        return flow {
            emit(databaseCall { characterDao.getAllFavorites() })
        }
    }

}