package com.projeto.movielist.di

import com.projeto.movielist.navigation.MovieListNavigationImpl
import com.projeto.navigation.MovieListNavigation
import com.projeto.common.koin.moduleprovider.ModuleProvider
import org.koin.core.module.Module
import org.koin.dsl.module

class MovieListModuleProvider : ModuleProvider() {
    override val modules: List<Module>
        get() = listOf(
            navigationModule
        )

    private val navigationModule = module {
        factory<MovieListNavigation> {
            MovieListNavigationImpl()
        }
    }
}