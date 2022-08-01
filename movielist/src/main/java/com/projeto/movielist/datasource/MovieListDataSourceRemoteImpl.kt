package com.projeto.movielist.datasource

import com.projeto.movielist.model.search.SearchResponse
import com.projeto.movielist.service.MovieListService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieListDataSourceRemoteImpl(
    private val movieListService: MovieListService
) : MovieListDataSourceRemote {

    override fun getMoviesByName(name: String) : Flow<SearchResponse> =
        flow {
            emit(movieListService.getMoviesByName(name))
        }

}