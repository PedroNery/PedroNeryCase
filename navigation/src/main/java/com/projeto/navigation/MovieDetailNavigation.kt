package com.projeto.navigation

import android.content.Context

interface MovieDetailNavigation {
    fun navigateToMovieDetailNavigation(context: Context, movieId: String)
}