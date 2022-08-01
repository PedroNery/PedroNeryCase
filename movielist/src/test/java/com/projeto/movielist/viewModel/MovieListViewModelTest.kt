package com.projeto.movielist.viewModel

import android.accounts.NetworkErrorException
import androidx.lifecycle.Observer
import com.projeto.movielist.model.movie.MovieResumed
import com.projeto.movielist.model.search.SearchDomain
import com.projeto.movielist.model.search.toDataUi
import com.projeto.movielist.domain.MovieListUseCase
import com.projeto.movielist.state.MovieListState
import com.projeto.movielist.viewmodel.MovieListViewModel
import com.projeto.pedronerycase.base.intent.UIAction
import com.projeto.pedronerycase.base.intent.UIState
import com.projeto.test.unit.InstantLiveDataAndCoroutineRules
import com.projeto.test.unit.ViewModelTestRule
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
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
    fun `searchMovieByName should set showContent when useCase return a SearchDomain with true response`() {
        //Given
        val anyString = RandomString().nextString()
        val movieMock: MovieResumed = mockk()
        val searchDomainMock = SearchDomain(
            response = true,
            search = listOf(movieMock),
            totalResults = "0",
            error = null
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

    @Test
    fun `searchMovieByName should set showError when useCase return a SearchDomain with false response`() {
        //Given
        val anyString = RandomString().nextString()
        val movieMock: MovieResumed = mockk()
        val searchDomainMock = SearchDomain(
            response = false,
            search = listOf(movieMock),
            totalResults = "0",
            error = "Nada encontrado"
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
            stateObserver.onChanged(initialState.showError(searchDataUIMock.error))
        }
    }

    @Test
    fun `searchMovieByName should set showError when useCase return IllegalArgumentException`() {
        //Given
        val anyString = RandomString().nextString()
        every {
            movieListUseCase.getMoviesByName(anyString)
        } returns flow { throw IllegalArgumentException() }

        //When
        viewModel.searchMovieByName(anyString)

        //Then
        verifySequence {
            stateObserver.onChanged(initialState)
            stateObserver.onChanged(initialState.showLoading(true))
            stateObserver.onChanged(initialState.showError("Digite ao menos 3 letras"))
        }
    }

    @Test
    fun `searchMovieByName should set showLoading false when useCase return other Exception`() {
        //Given
        val anyString = RandomString().nextString()
        every {
            movieListUseCase.getMoviesByName(anyString)
        } returns flow { throw NetworkErrorException() }

        //When
        viewModel.searchMovieByName(anyString)

        //Then
        verifySequence {
            stateObserver.onChanged(initialState)
            stateObserver.onChanged(initialState.showLoading(true))
            stateObserver.onChanged(initialState.showLoading(false))
        }
    }
}