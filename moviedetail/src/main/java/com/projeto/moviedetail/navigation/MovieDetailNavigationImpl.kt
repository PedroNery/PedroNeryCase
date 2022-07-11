package com.projeto.moviedetail.navigation

import android.content.Context
import android.content.Intent
import com.projeto.moviedetail.MovieDetailActivity
import com.projeto.navigation.MovieDetailNavigation
import com.projeto.navigation.MovieListNavigation

internal class MovieDetailNavigationImpl : MovieDetailNavigation {

    override fun navigateToMovieDetailNavigation(context: Context) {
        val intent = Intent(context, MovieDetailActivity::class.java)
        context.startActivity(intent)
    }

}