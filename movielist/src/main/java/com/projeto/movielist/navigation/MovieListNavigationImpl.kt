package com.projeto.movielist.navigation

import android.content.Context
import android.content.Intent
import com.projeto.movielist.view.MovieListActivity
import com.projeto.navigation.MovieListNavigation

internal class MovieListNavigationImpl : MovieListNavigation {

    override fun navigateToMovieListNavigation(context: Context) {
        val intent = Intent(context, MovieListActivity::class.java)
        context.startActivity(intent)
    }

}