package com.projeto.launcher.di

import com.projeto.common.koin.aware.scopemodule.ScopeModule
import com.projeto.launcher.viewmodel.LauncherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.ScopeDSL

internal object LauncherActivityScopeModule : ScopeModule() {
    override fun ScopeDSL.getPresentation() = dependencies {
        viewModel { LauncherViewModel() }
    }
}