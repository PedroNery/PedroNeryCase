package com.projeto.moviedetail.di

import com.projeto.common.koin.aware.scopemodule.ScopeModule
import com.projeto.moviedetail.datasource.MovieDetailDataSourceRemote
import com.projeto.moviedetail.datasource.MovieDetailDataSourceRemoteImpl
import com.projeto.moviedetail.domain.MovieDetailUseCase
import com.projeto.moviedetail.domain.MovieDetailUseCaseImpl
import com.projeto.moviedetail.repository.MovieDetailRepository
import com.projeto.moviedetail.repository.MovieDetailRepositoryImpl
import com.projeto.moviedetail.service.MovieDetailService
import com.projeto.moviedetail.viewmodel.MovieDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.ScopeDSL
import org.koin.dsl.module
import retrofit2.Retrofit

internal object MovieDetailModule : ScopeModule() {
    override fun ScopeDSL.getData() = dependencies {
        factory<MovieDetailDataSourceRemote> {
            MovieDetailDataSourceRemoteImpl(getService(get()))
        }

        factory<MovieDetailRepository> {
            MovieDetailRepositoryImpl(get())
        }
    }

    override fun ScopeDSL.getDomain() = dependencies {
        factory<MovieDetailUseCase> {
            MovieDetailUseCaseImpl(get())
        }
    }

    override fun ScopeDSL.getPresentation() = dependencies {
        viewModel {
            MovieDetailViewModel(get())
        }
    }
}

private fun getService(retrofit: Retrofit) = retrofit.create(MovieDetailService::class.java)