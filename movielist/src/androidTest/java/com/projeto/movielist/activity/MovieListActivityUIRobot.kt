package com.projeto.movielist.activity

import androidx.lifecycle.MutableLiveData
import androidx.test.platform.app.InstrumentationRegistry
import com.projeto.movielist.action.MovieListAction
import com.projeto.movielist.state.MovieListState
import com.projeto.movielist.testUtils.MovieListStub
import com.projeto.movielist.view.MovieListActivity
import com.projeto.movielist.viewmodel.MovieListViewModel
import com.projeto.test.ui.base.TestLiveData
import com.projeto.test.ui.robot.RobotArrangement
import io.mockk.every
import io.mockk.mockk
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

class MovieListActivityUIRobot : RobotArrangement<MovieListActionRobot> {
    private val fakeState = TestLiveData<MovieListState>()
    private val fakeAction = TestLiveData<MovieListAction>()

    override fun beforeAction() {
        setupKoinModules()
    }

    private fun setupKoinModules() {
        val presentationModule = module {
            scope<MovieListActivity> {
                viewModel { stubMovieListViewModel() } }
            }
        loadKoinModules(presentationModule)
    }

    fun setSuccessState() {
        val successState = MovieListState().showContent(
            MovieListStub.movieListStub.search
        )
        fakeState.setValueOnMainThread(successState)
    }

    fun setErrorState(value: String) {
        val errorState = MovieListState().showError(
            value
        )
        fakeState.setValueOnMainThread(errorState)
    }

    fun setLoadingState() {
        val loadingState = MovieListState().showLoading(
            true
        )
        fakeState.setValueOnMainThread(loadingState)
    }

    private fun stubMovieListViewModel(): MovieListViewModel {
        return mockk(relaxed = true) {
            every { state } returns fakeState
            every { action } returns fakeAction
        }
    }

}