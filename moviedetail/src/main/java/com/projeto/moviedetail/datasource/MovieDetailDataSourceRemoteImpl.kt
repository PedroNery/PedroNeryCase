package com.projeto.moviedetail.datasource

import com.projeto.moviedetail.model.MovieDetail
import com.projeto.moviedetail.service.MovieDetailService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieDetailDataSourceRemoteImpl(
    private val movieDetailService: MovieDetailService
) : MovieDetailDataSourceRemote {

    override fun getMovieDetailById(id: String) : Flow<MovieDetail> =
        flow {
            emit(movieDetailService.getMovieDetailById(id))
        }
}