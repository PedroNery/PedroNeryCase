package com.projeto.movielist.view

import android.os.Bundle
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.projeto.common.base.extensions.onStateChange
import com.projeto.common.base.view.GridSpacingItemDecoration
import com.projeto.common.base.viewbinding.viewBinding
import com.projeto.common.koin.aware.scopemodule.KoinActivity
import com.projeto.movielist.R
import com.projeto.movielist.databinding.ActivityMovieListBinding
import com.projeto.movielist.di.MovieListModule
import com.projeto.movielist.state.MovieListState
import com.projeto.movielist.view.adapter.MovieSearchAdapter
import com.projeto.movielist.viewmodel.MovieListViewModel
import com.projeto.navigation.MovieDetailNavigation
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieListActivity : KoinActivity(R.layout.activity_movie_list, MovieListModule) {

    private val viewModel: MovieListViewModel by viewModel()
    private val binding: ActivityMovieListBinding by viewBinding(R.id.movieListActivityRoot)
    private val movieDetailNavigation: MovieDetailNavigation by inject()
    private val adapter : MovieSearchAdapter by lazy {
        MovieSearchAdapter(
            movieItemOnClick
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initEditTextObserver()
        initRecyclerView()
        onStateChange(viewModel, ::handleState)
    }

    private fun initRecyclerView() {
        binding.rvMovieList.adapter = adapter
        binding.rvMovieList.addItemDecoration(GridSpacingItemDecoration(2, 70, false))
    }

    private fun initEditTextObserver() {
        binding.etSearchMovie.addTextChangedListener { name ->
            viewModel.searchMovieByName(name.toString())
        }
    }

    private fun handleState(state: MovieListState) {
        binding.loading.isVisible = state.showLoading
        binding.tvError.isVisible = state.showError
        binding.tvError.text = state.errorMessage
        binding.rvMovieList.isVisible = state.showContent
        adapter.submitList(state.movieList)
    }

    private val movieItemOnClick: (movieId : String) -> Unit = { movieId ->
        movieDetailNavigation.navigateToMovieDetailNavigation(this, movieId)
    }

}