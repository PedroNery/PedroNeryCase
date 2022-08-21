package com.projeto.movielist.di

import com.projeto.common.koin.aware.scopemodule.ScopeModule
import com.projeto.movielist.datasource.MovieListDataSourceRemote
import com.projeto.movielist.datasource.MovieListDataSourceRemoteImpl
import com.projeto.movielist.domain.MovieListUseCase
import com.projeto.movielist.domain.MovieListUseCaseImpl
import com.projeto.movielist.repository.MovieListRepository
import com.projeto.movielist.repository.MovieListRepositoryImpl
import com.projeto.movielist.service.MovieListService
import com.projeto.movielist.viewmodel.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.ScopeDSL
import retrofit2.Retrofit

internal object MovieListModule : ScopeModule() {
    override fun ScopeDSL.getData() = dependencies {
        factory<MovieListDataSourceRemote> {
            MovieListDataSourceRemoteImpl(getService(get()))
        }

        factory<MovieListRepository> {
            MovieListRepositoryImpl(get())
        }
    }

    override fun ScopeDSL.getDomain() = dependencies {
        factory<MovieListUseCase> {
            MovieListUseCaseImpl(get())
        }
    }

    override fun ScopeDSL.getPresentation() = dependencies {
        viewModel {
            MovieListViewModel(get())
        }
    }
}

private fun getService(retrofit: Retrofit) = retrofit.create(MovieListService::class.java)