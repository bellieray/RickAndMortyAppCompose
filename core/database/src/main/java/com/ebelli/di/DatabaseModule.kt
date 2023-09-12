package com.ebelli.di

import android.app.Application
import androidx.room.Room
import com.ebelli.dao.CharacterDao
import com.ebelli.db.CharacterDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideCharacterDB(app: Application): CharacterDb {
        return Room.databaseBuilder(
            app, CharacterDb::class.java, "coin_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCharacterDao(characterDB: CharacterDb): CharacterDao {
        return characterDB.characterDao()
    }
}