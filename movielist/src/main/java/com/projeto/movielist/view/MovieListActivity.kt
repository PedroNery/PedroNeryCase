package com.projeto.movielist.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.projeto.common.base.extensions.modules
import com.projeto.common.base.extensions.onStateChange
import com.projeto.common.base.view.GridSpacingItemDecoration
import com.projeto.common.base.viewbinding.viewBinding
import com.projeto.common.koin.aware.KoinAware
import com.projeto.common.koin.aware.ModuleList
import com.projeto.movielist.R
import com.projeto.movielist.databinding.ActivityMovieListBinding
import com.projeto.movielist.di.movieListPresentationModule
import com.projeto.movielist.state.MovieListState
import com.projeto.movielist.view.adapter.MovieSearchAdapter
import com.projeto.movielist.viewmodel.MovieListViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MovieListActivity : AppCompatActivity(R.layout.activity_movie_list), KoinAware {

    override val subModules: ModuleList by modules(movieListPresentationModule)

    private val viewModel: MovieListViewModel by viewModel()
    private val binding: ActivityMovieListBinding by viewBinding(R.id.movieListActivityRoot)
    private var adapter = MovieSearchAdapter(listOf())

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
        binding.rvMovieList.isVisible = state.showContent
        adapter.updateList(state.movieList)
    }

}