package com.projeto.moviedetail.di

import com.projeto.moviedetail.datasource.MovieDetailDataSourceRemoteImpl
import com.projeto.moviedetail.domain.MovieDetailUseCaseImpl
import com.projeto.moviedetail.repository.MovieDetailRepositoryImpl
import com.projeto.moviedetail.service.MovieDetailService
import com.projeto.moviedetail.viewmodel.MovieDetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

internal val movieDetailPresentationModule = module {

    viewModel {
        MovieDetailViewModel(
            movieDetailUseCase = MovieDetailUseCaseImpl(
                movieDetailRepository = MovieDetailRepositoryImpl(
                    movieDetailDataSourceRemote = MovieDetailDataSourceRemoteImpl(
                        getService(get())
                    )
                )
            )
        )
    }

}

private fun getService(retrofit: Retrofit) = retrofit.create(MovieDetailService::class.java)