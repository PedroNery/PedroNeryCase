package com.projeto.moviedetail.datasource

import com.projeto.moviedetail.model.MovieDetail
import kotlinx.coroutines.flow.Flow

interface MovieDetailDataSourceRemote {
    fun getMovieDetailById(id: String) : Flow<MovieDetail>
}