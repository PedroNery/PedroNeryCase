package com.projeto.movielist.model.search

import com.projeto.movielist.model.movie.MovieResumed

data class SearchDataUI(
    val response: Boolean,
    val search: List<MovieResumed>?,
    val error: String?
)
