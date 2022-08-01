package com.projeto.moviedetail.state

import com.projeto.moviedetail.model.MovieDetailDataUI
import com.projeto.pedronerycase.base.intent.UIState

data class MovieDetailState(
    val showLoading: Boolean = false,
    val showError: Boolean = false,
    val showContent: Boolean = false,
    val movieDetail: MovieDetailDataUI = MovieDetailDataUI()
) : UIState {

    fun showLoading(loading: Boolean): MovieDetailState {
        return this.copy(
            showError = false,
            showContent = false,
            showLoading = loading
        )
    }

    fun showError(): MovieDetailState {
        return this.copy(
            showError = true,
            showContent = false,
            showLoading = false
        )
    }

    fun showContent(movieDetail: MovieDetailDataUI) : MovieDetailState {
        return this.copy(
            showError = false,
            showLoading = false,
            showContent = true,
            movieDetail = movieDetail
        )
    }

}