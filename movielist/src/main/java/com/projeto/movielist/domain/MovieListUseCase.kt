package com.projeto.movielist.domain

import com.projeto.common.model.search.SearchDomain
import kotlinx.coroutines.flow.Flow

interface MovieListUseCase {
    fun getMoviesByName(name: String) : Flow<SearchDomain>
}