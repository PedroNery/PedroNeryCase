package com.projeto.movielist.datasource

import com.projeto.movielist.model.search.SearchResponse
import kotlinx.coroutines.flow.Flow

interface MovieListDataSourceRemote {
    fun getMoviesByName(name: String) : Flow<SearchResponse>
}