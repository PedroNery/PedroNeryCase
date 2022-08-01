package com.projeto.movielist.model.search

import com.projeto.movielist.model.movie.MovieResumed

data class SearchDomain(
    val response: Boolean,
    val search: List<MovieResumed>?,
    val totalResults: String?,
    val error: String?
)