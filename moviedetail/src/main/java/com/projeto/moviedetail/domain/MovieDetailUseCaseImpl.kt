package com.projeto.moviedetail.domain

import com.projeto.moviedetail.model.MovieDetailDomain
import com.projeto.moviedetail.repository.MovieDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MovieDetailUseCaseImpl(
    private val movieDetailRepository: MovieDetailRepository
) : MovieDetailUseCase {
    override fun getMovieDetailById(id: String): Flow<MovieDetailDomain> {
        return movieDetailRepository.getMovieDetailById(id)
    }
}