package com.ebelli.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)


data class CharacterResponse(
    val info: Info,
    val results: List<Character>
)

@Entity("character_entity")
data class Character(
    @ColumnInfo(name = "id")
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "status")
    val status: String,
    @ColumnInfo(name = "species")
    val species: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "gender")
    val gender: String,
    @ColumnInfo(name = "origin")
    val origin: Location,
    @ColumnInfo(name = "location")
    val location: Location,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "episode")
    val episode: List<String>,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "created")
    val created: String,
    var isFavorite: Boolean = false
)

data class Location(
    val name: String,
    val url: String
)
