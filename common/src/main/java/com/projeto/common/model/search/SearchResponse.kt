package com.projeto.common.model.search

import com.google.gson.annotations.SerializedName
import com.projeto.common.model.movie.Movie

data class SearchResponse(
    @SerializedName("Response")
    val response: Boolean,
    @SerializedName("Search")
    val search: List<Movie>?,
    @SerializedName("totalResults")
    val totalResults: String?
)