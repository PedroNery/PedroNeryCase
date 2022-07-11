package com.projeto.movielist.di

import com.projeto.movielist.datasource.MovieDataSourceImpl
import com.projeto.movielist.domain.MovieListUseCaseImpl
import com.projeto.movielist.repository.MovieListRepositoryImpl
import com.projeto.movielist.service.MovieService
import com.projeto.movielist.viewmodel.MovieListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

internal val movieListPresentationModule = module {

    viewModel {
        MovieListViewModel(
            movieListUseCase = MovieListUseCaseImpl(
                movieListRepository = MovieListRepositoryImpl(
                    movieDataSource = MovieDataSourceImpl(
                        getService(get())
                    )
                )
            )
        )
    }

}

private fun getService(retrofit: Retrofit) = retrofit.create(MovieService::class.java)