package com.projeto.moviedetail.ui

import androidx.activity.ComponentActivity
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import com.projeto.moviedetail.viewmodel.MovieDetailViewModel
import org.koin.android.viewmodel.ext.android.viewModel

@Composable
fun MovieDetailScreen(id: String, activity: ComponentActivity) {

    val movieDetailViewModel: MovieDetailViewModel by activity.viewModel()
    val state by remember { movieDetailViewModel.getState() }

    LaunchedEffect(movieDetailViewModel) {
        movieDetailViewModel.searchMovieDetailById(id)
    }

    if(state.showError)
        MovieDetailError {
            movieDetailViewModel.searchMovieDetailById(id)
        }
    else
        MovieDetailComponent(
                movieDetailDataUI = state.movieDetail,
                isLoading = state.showLoading)

}