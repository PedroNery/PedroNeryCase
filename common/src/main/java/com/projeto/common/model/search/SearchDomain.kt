package com.projeto.common.model.search

import com.projeto.common.model.movie.Movie

data class SearchDomain(
    val response: Boolean,
    val search: List<Movie>?,
    val totalResults: String?,
    val error: String?
)