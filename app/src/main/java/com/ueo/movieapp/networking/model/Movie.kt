package com.ueo.movieapp.networking.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    @Json(name = "poster_path") val posterPath: String?
) {
    override fun toString(): String {
        return "Movie(id=$id, title='$title', overview='$overview', posterPath='$posterPath')"
    }
}