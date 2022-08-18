package com.projeto.movielist.viewmodel

import androidx.lifecycle.viewModelScope
import com.projeto.movielist.model.search.SearchDataUI
import com.projeto.movielist.model.search.toDataUi
import com.projeto.movielist.action.MovieListAction
import com.projeto.movielist.domain.MovieListUseCase
import com.projeto.movielist.state.MovieListState
import com.projeto.pedronerycase.base.viewmodel.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MovieListViewModel(
    private val movieListUseCase: MovieListUseCase,
    private val dispatcher : CoroutineDispatcher = Dispatchers.IO
) : ViewModel<MovieListState, MovieListAction>(MovieListState()) {

    fun searchMovieByName(name: String) {
        viewModelScope.launch {
            movieListUseCase.getMoviesByName(name)
                .flowOn(dispatcher)
                .onStart { setState { state -> state.showLoading(true) } }
                .catch { handleError(it) }
                .collect {
                    handleSearchResult(it.toDataUi())
                }
        }
    }

    private fun handleError(error: Throwable) {
        if (error !is IllegalArgumentException)
            setState { state -> state.showLoading(false) }
        else
            setState { state -> state.showError(error.message) }
    }

    private fun handleSearchResult(searchDataUI: SearchDataUI) {
        if(searchDataUI.response)
            setState { state -> state.showContent(searchDataUI.search)}
        else
            setState { state -> state.showError(searchDataUI.error) }
    }

}
