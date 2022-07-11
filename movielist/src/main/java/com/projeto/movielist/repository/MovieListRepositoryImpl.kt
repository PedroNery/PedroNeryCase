package com.projeto.movielist.repository

import com.projeto.common.model.search.SearchDomain
import com.projeto.common.model.search.toDomain
import com.projeto.movielist.datasource.MovieDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieListRepositoryImpl(
    private val movieDataSource: MovieDataSource
) : MovieListRepository {

    override fun getMoviesByName(name: String) : Flow<SearchDomain> {
        return movieDataSource.getMoviesByName(name).map {
            it.toDomain()
        }
    }

}