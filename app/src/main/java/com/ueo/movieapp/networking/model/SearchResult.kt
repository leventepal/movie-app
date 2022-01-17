package com.ueo.movieapp.networking.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResult(
    val page: Int,
    val results: List<Movie>
) {
    override fun toString(): String {
        return "SearchResult(page=$page, results=$results)"
    }
}