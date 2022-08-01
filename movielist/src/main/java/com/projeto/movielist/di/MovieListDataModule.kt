package com.projeto.movielist.di

import com.projeto.movielist.datasource.MovieListDataSourceRemoteImpl
import com.projeto.movielist.domain.MovieListUseCaseImpl
import com.projeto.movielist.repository.MovieListRepositoryImpl
import com.projeto.movielist.service.MovieListService
import com.projeto.movielist.viewmodel.MovieListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

internal val movieListPresentationModule = module {

    viewModel {
        MovieListViewModel(
            movieListUseCase = MovieListUseCaseImpl(
                movieListRepository = MovieListRepositoryImpl(
                    movieListDataSourceRemote = MovieListDataSourceRemoteImpl(
                        getService(get())
                    )
                )
            )
        )
    }

}

private fun getService(retrofit: Retrofit) = retrofit.create(MovieListService::class.java)