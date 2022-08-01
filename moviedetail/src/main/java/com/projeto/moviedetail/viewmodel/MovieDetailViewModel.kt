package com.projeto.moviedetail.viewmodel

import androidx.lifecycle.viewModelScope
import com.projeto.common.base.viewmodel.StateComposeViewModel
import com.projeto.moviedetail.domain.MovieDetailUseCase
import com.projeto.moviedetail.model.toDataUI
import com.projeto.moviedetail.state.MovieDetailState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val movieDetailUseCase: MovieDetailUseCase
) : StateComposeViewModel<MovieDetailState>(MovieDetailState()) {

    fun searchMovieDetailById(id: String) {
        viewModelScope.launch {
            movieDetailUseCase.getMovieDetailById(id)
                .flowOn(Dispatchers.IO)
                .onStart { setState { state -> state.showLoading(true) } }
                .catch { setState { state -> state.showError() } }
                .collect { setState { state -> state.showContent(it.toDataUI()) } }
        }
    }

}