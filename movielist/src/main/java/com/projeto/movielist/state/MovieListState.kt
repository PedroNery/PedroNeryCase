package com.projeto.movielist.state

import com.projeto.common.model.movie.Movie
import com.projeto.pedronerycase.base.intent.UIState

data class MovieListState(
    val showLoading: Boolean = false,
    val showError: Boolean = false,
    val errorMessage: String = "",
    val showContent: Boolean = false,
    val movieList: List<Movie>? = listOf()
) : UIState {

    fun showLoading(loading: Boolean): MovieListState {
        return this.copy(
            showError = false,
            showContent = false,
            showLoading = loading,
            errorMessage = ""
        )
    }

    fun showError(message: String?): MovieListState {
        return this.copy(
            showError = true,
            errorMessage = message ?: "",
            showContent = false,
            showLoading = false
        )
    }

    fun showContent(movieList: List<Movie>?) : MovieListState {
        return this.copy(
            showError = false,
            showLoading = false,
            showContent = true,
            movieList = movieList,
            errorMessage = ""
        )
    }

}