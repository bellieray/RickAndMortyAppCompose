package com.ebelli.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.ebelli.dao.CharacterDao
import com.ebelli.model.Character
import com.ebelli.model.Location
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Database(
    entities = [Character::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(LocationTypeConverter::class)
abstract class CharacterDb : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}

class LocationTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun locationToString(location: Location): String {
        return gson.toJson(location)
    }

    @TypeConverter
    fun stringToLocation(locationString: String): Location {
        return gson.fromJson(locationString, Location::class.java)
    }

    @TypeConverter
    fun episodeToString(episodeList: List<String>): String {
        return gson.toJson(episodeList)
    }

    @TypeConverter
    fun stringToEpisode(episodeString: String): List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(episodeString, type)
    }
}