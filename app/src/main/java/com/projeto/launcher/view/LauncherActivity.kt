package com.projeto.launcher.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projeto.R
import com.projeto.common.base.extensions.modules
import com.projeto.common.base.extensions.onAction
import com.projeto.common.koin.aware.KoinAware
import com.projeto.launcher.action.LauncherAction
import com.projeto.launcher.di.presentationModule
import com.projeto.movielist.view.MovieListActivity
import com.projeto.teste.launcher.viewmodel.LauncherViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LauncherActivity : AppCompatActivity(R.layout.activity_launcher), KoinAware {

    override val subModules by modules(presentationModule)

    private val viewModel: LauncherViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onAction(viewModel, ::handleAction)
    }

    private fun handleAction(action: LauncherAction) {
        when (action) {
            LauncherAction.NavigateToMovieList -> {
                val intent = Intent(this, MovieListActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

}