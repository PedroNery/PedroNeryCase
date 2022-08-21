package com.projeto.moviedetail.view

import android.os.Bundle
import androidx.activity.compose.setContent
import com.projeto.common.koin.aware.scopemodule.KoinActivity
import com.projeto.moviedetail.di.MovieDetailModule
import com.projeto.moviedetail.ui.MovieDetailScreen

class MovieDetailActivity : KoinActivity(scopeModule = MovieDetailModule) {

    private val movieId: String by lazy {
        intent.getStringExtra("movieId") ?: ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieDetailScreen(id = movieId, activity = this)
        }
    }

}