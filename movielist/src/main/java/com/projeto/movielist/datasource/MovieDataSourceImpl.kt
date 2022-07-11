package com.projeto.movielist.datasource

import com.projeto.common.model.search.SearchResponse
import com.projeto.movielist.service.MovieService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieDataSourceImpl(
    private val movieService: MovieService
) : MovieDataSource {

    override fun getMoviesByName(name: String) : Flow<SearchResponse> =
        flow {
            emit(movieService.getMoviesByName(name))
        }

}