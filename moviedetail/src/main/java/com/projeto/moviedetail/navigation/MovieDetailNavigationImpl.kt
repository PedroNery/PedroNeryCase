package com.projeto.moviedetail.navigation

import android.content.Context
import android.content.Intent
import com.projeto.moviedetail.view.MovieDetailActivity
import com.projeto.navigation.MovieDetailNavigation

internal class MovieDetailNavigationImpl : MovieDetailNavigation {

    override fun navigateToMovieDetailNavigation(context: Context, movieId: String) {
        val intent = Intent(context, MovieDetailActivity::class.java)
        intent.putExtra("movieId", movieId)
        context.startActivity(intent)
    }

}