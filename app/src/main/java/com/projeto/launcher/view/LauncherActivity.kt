package com.projeto.launcher.view

import android.content.Intent
import android.os.Bundle
import com.projeto.R
import com.projeto.common.base.extensions.onAction
import com.projeto.common.koin.aware.scopemodule.KoinActivity
import com.projeto.launcher.action.LauncherAction
import com.projeto.launcher.di.LauncherActivityScopeModule
import com.projeto.movielist.view.MovieListActivity
import com.projeto.launcher.viewmodel.LauncherViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LauncherActivity : KoinActivity(R.layout.activity_launcher, LauncherActivityScopeModule) {

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