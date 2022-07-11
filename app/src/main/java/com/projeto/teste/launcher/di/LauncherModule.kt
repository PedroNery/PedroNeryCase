package com.projeto.teste.launcher.di

import com.projeto.teste.launcher.viewmodel.LauncherViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val presentationModule = module {

    viewModel {
        LauncherViewModel()
    }

}