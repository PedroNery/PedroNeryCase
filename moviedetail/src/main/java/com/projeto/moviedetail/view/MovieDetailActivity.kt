package com.projeto.moviedetail.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.projeto.common.base.extensions.modules
import com.projeto.common.koin.aware.KoinAware
import com.projeto.common.koin.aware.ModuleList
import com.projeto.moviedetail.di.movieDetailPresentationModule
import com.projeto.moviedetail.ui.MovieDetailScreen

class MovieDetailActivity : ComponentActivity(), KoinAware {

    override val subModules: ModuleList by modules(movieDetailPresentationModule)

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