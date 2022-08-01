package com.projeto.movielist.domain

import com.projeto.movielist.model.search.SearchDomain
import kotlinx.coroutines.flow.Flow

interface MovieListUseCase {
    fun getMoviesByName(name: String) : Flow<SearchDomain>
}