package com.projeto.movielist.activity

import androidx.lifecycle.MutableLiveData
import androidx.test.platform.app.InstrumentationRegistry
import com.projeto.movielist.action.MovieListAction
import com.projeto.movielist.state.MovieListState
import com.projeto.movielist.testUtils.MovieListStub
import com.projeto.movielist.viewmodel.MovieListViewModel
import com.projeto.test.ui.robot.RobotArrangement
import io.mockk.every
import io.mockk.mockk
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

class MovieListActivityUIRobot : RobotArrangement<MovieListActionRobot> {
    private val fakeState = MutableLiveData<MovieListState>()
    private val fakeAction = MutableLiveData<MovieListAction>()

    override fun beforeAction() {
        setupKoinModules()
    }

    private fun setupKoinModules() {
        val presentationModule = module { viewModel { stubMovieListViewModel() } }
        loadKoinModules(
            presentationModule
        )
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

    private fun <T> MutableLiveData<T>.setValueOnMainThread(value: T) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            this.value = value
        }
    }
}