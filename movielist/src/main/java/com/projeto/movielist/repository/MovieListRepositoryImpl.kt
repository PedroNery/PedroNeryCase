package com.projeto.movielist.repository

import com.projeto.movielist.model.search.SearchDomain
import com.projeto.movielist.model.search.toDomain
import com.projeto.movielist.datasource.MovieListDataSourceRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieListRepositoryImpl(
    private val movieListDataSourceRemote: MovieListDataSourceRemote
) : MovieListRepository {

    override fun getMoviesByName(name: String) : Flow<SearchDomain> {
        return movieListDataSourceRemote.getMoviesByName(name).map {
            it.toDomain()
        }
    }

}