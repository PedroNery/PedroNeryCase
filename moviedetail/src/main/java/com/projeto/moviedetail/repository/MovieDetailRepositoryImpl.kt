package com.projeto.moviedetail.repository

import com.projeto.moviedetail.datasource.MovieDetailDataSourceRemote
import com.projeto.moviedetail.model.MovieDetailDomain
import com.projeto.moviedetail.model.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class MovieDetailRepositoryImpl(
    private val movieDetailDataSourceRemote: MovieDetailDataSourceRemote
) : MovieDetailRepository {

    override fun getMovieDetailById(id: String) : Flow<MovieDetailDomain> {
        return movieDetailDataSourceRemote.getMovieDetailById(id).map {
            it.toDomain()
        }
    }

}