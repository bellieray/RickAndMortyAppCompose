package com.ebelli.model

data class LocationInfo(
    val info: Info,
    val results: List<LocationResponse>?
)

data class LocationResponse(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: String,
    var isFavorite: Boolean = false
) {
    fun getIds(): List<String>{
        return residents.map { url ->
            val urlParts = url.split("/")
            val endNumber = urlParts.last()
            endNumber ?: throw IllegalArgumentException("Invalid URL format: $url")
        }

    }
}