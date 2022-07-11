package com.projeto.movielist.repository

import com.projeto.common.model.search.SearchDomain
import kotlinx.coroutines.flow.Flow

interface MovieListRepository {
    fun getMoviesByName(name: String) : Flow<SearchDomain>
}