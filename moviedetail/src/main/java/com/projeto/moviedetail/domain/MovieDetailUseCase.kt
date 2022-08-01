package com.projeto.moviedetail.domain

import com.projeto.moviedetail.model.MovieDetailDomain
import kotlinx.coroutines.flow.Flow

interface MovieDetailUseCase {
    fun getMovieDetailById(id: String) : Flow<MovieDetailDomain>
}