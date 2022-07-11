package com.projeto.moviedetail.di

import com.projeto.common.koin.moduleprovider.ModuleProvider
import com.projeto.moviedetail.navigation.MovieDetailNavigationImpl
import com.projeto.navigation.MovieDetailNavigation
import org.koin.core.module.Module
import org.koin.dsl.module

class MovieDetailModuleProvider : ModuleProvider() {
    override val modules: List<Module>
        get() = listOf(
            navigationModule
        )

    private val navigationModule = module {
        factory<MovieDetailNavigation> {
            MovieDetailNavigationImpl()
        }
    }
}