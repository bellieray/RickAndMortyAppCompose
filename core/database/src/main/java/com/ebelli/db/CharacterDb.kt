package com.ebelli.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ebelli.dao.CharacterDao
import com.ebelli.model.Character

@Database(
    entities = [Character::class],
    version = 1,
    exportSchema = false
)
abstract class CharacterDb : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}