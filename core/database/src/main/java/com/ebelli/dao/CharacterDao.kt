package com.ebelli.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ebelli.model.Character

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavorites(character: Character)

    @Query("DELETE FROM character_entity WHERE id = :id")
    suspend fun removeFromFavorites(id: Int)

    @Query("SELECT * FROM character_entity")
    suspend fun getAllFavorites(): List<Character>

}