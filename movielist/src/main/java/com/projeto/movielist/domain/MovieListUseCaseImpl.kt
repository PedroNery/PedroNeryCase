package com.projeto.movielist.domain

import com.projeto.common.model.search.SearchDomain
import com.projeto.movielist.repository.MovieListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.IllegalArgumentException

class MovieListUseCaseImpl(
    private val movieListRepository: MovieListRepository
) : MovieListUseCase {

    override fun getMoviesByName(name: String) : Flow<SearchDomain> {
        return if(name.length >= 3)
            movieListRepository.getMoviesByName(name)
        else
            flow { throw IllegalArgumentException("Digite ao menos 3 letras") }
    }

}