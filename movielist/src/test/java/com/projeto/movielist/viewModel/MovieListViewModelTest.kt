package com.projeto.movielist.viewModel

import androidx.lifecycle.Observer
import com.projeto.common.model.movie.Movie
import com.projeto.common.model.search.SearchDomain
import com.projeto.common.model.search.toDataUi
import com.projeto.movielist.domain.MovieListUseCase
import com.projeto.movielist.state.MovieListState
import com.projeto.movielist.viewmodel.MovieListViewModel
import com.projeto.pedronerycase.base.intent.UIAction
import com.projeto.pedronerycase.base.intent.UIState
import com.projeto.test.InstantLiveDataAndCoroutineRules
import com.projeto.test.ViewModelTestRule
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import net.bytebuddy.utility.RandomString
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MovieListViewModelTest {

    private val movieListUseCase: MovieListUseCase = mockk()
    private val initialState: MovieListState = MovieListState()
    private lateinit var viewModel: MovieListViewModel
    private lateinit var stateObserver: Observer<UIState>
    private lateinit var actionObserver: Observer<UIAction>

    @get:Rule
    val viewModelRule = ViewModelTestRule(
        stateObserver = mockk(relaxed = true),
        actionObserver = mockk(relaxed = true)
    )

    @get:Rule
    val instantLiveDataAndCoroutineRules = InstantLiveDataAndCoroutineRules()

    @Before
    fun setUp(){
        viewModel = MovieListViewModel(movieListUseCase)
        stateObserver = viewModelRule.getStateObsever()
        actionObserver = viewModelRule.getActionObsever()
    }

    @Test
    fun `searchMovieByName should set showContent when useCase return a SearchDomain`() {
        //Given
        val anyString = RandomString().nextString()
        val movieMock: Movie = mockk()
        val searchDomainMock = SearchDomain(
            response = true,
            search = listOf(movieMock),
            totalResults = "0"
        )
        val searchDataUIMock = searchDomainMock.toDataUi()
        every {
            movieListUseCase.getMoviesByName(anyString)
        } returns flow { emit(searchDomainMock) }

        //When
        viewModel.searchMovieByName(anyString)

        //Then
        verifySequence {
            stateObserver.onChanged(initialState)
            stateObserver.onChanged(initialState.showLoading(true))
            stateObserver.onChanged(initialState.showContent(searchDataUIMock.search))
        }
    }
}