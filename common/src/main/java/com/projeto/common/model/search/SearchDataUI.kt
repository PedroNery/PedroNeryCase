package com.projeto.common.model.search

import com.projeto.common.model.Movie

data class SearchDataUI(
    val response: Boolean,
    val search: List<Movie>?
)
