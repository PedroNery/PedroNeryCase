package com.projeto.teste.launcher.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projeto.common.base.extensions.modules
import com.projeto.common.base.extensions.onAction
import com.projeto.navigation.MovieListNavigation
import com.projeto.pedronerycase.koin.aware.KoinAware
import com.projeto.pedronerycase.koin.aware.ModuleList
import com.projeto.teste.R
import com.projeto.teste.launcher.action.LauncherAction
import com.projeto.teste.launcher.di.presentationModule
import com.projeto.teste.launcher.viewmodel.LauncherViewModel
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class LauncherActivity : AppCompatActivity(R.layout.activity_launcher), KoinAware {

    override val subModules by modules(presentationModule)

    private val viewModel : LauncherViewModel by viewModel()
    private val movieListNavigation : MovieListNavigation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onAction(viewModel, ::handleAction)
    }

    private fun handleAction(action: LauncherAction){
        when(action){
            LauncherAction.NavigateToMovieList -> {
                movieListNavigation.navigateToMovieListNavigation(context = this)
            }
        }
    }

}