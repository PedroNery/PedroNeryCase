package com.projeto.moviedetail.repository

import com.projeto.moviedetail.model.MovieDetailDomain
import kotlinx.coroutines.flow.Flow

interface MovieDetailRepository {
    fun getMovieDetailById(id: String) : Flow<MovieDetailDomain>
}