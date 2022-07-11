package com.projeto.movielist.datasource

import com.projeto.common.model.search.SearchResponse
import kotlinx.coroutines.flow.Flow

interface MovieDataSource {
    fun getMoviesByName(name: String) : Flow<SearchResponse>
}