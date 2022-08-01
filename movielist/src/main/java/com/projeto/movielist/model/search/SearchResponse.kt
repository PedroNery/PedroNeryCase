package com.projeto.movielist.model.search

import com.google.gson.annotations.SerializedName
import com.projeto.movielist.model.movie.MovieResumed

data class SearchResponse(
    @SerializedName("Response")
    val response: Boolean,
    @SerializedName("Search")
    val search: List<MovieResumed>?,
    @SerializedName("totalResults")
    val totalResults: String?,
    @SerializedName("Error")
    val error: String?
)