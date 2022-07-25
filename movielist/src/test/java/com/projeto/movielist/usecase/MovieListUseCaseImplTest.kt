package com.projeto.movielist.usecase

import app.cash.turbine.test
import com.projeto.common.model.search.SearchDomain
import com.projeto.movielist.domain.MovieListUseCase
import com.projeto.movielist.domain.MovieListUseCaseImpl
import com.projeto.movielist.repository.MovieListRepository
import com.projeto.test.unit.InstantLiveDataAndCoroutineRules
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.core.IsInstanceOf
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Rule
import org.junit.Test
import java.lang.Exception
import java.lang.IllegalArgumentException
import kotlin.time.ExperimentalTime

@ExperimentalCoroutinesApi
@ExperimentalTime
class MovieListUseCaseImplTest {

    private val movieListRepository: MovieListRepository = mockk()

    private val movieListUseCaseImpl : MovieListUseCase by lazy {
        MovieListUseCaseImpl(movieListRepository)
    }

    @get:Rule
    val instantLiveDataAndCoroutineRules = InstantLiveDataAndCoroutineRules()

    @Test
    fun `getMoviesByName should return SearchDomain when movie name length is bigger then 2 and repository return success`() = runBlockingTest {
        //Given
        val searchDomain : SearchDomain = mockk()
        coEvery {
            movieListRepository.getMoviesByName(any())
        } returns flow { emit(searchDomain) }

        //When
        val movieListFlow = movieListUseCaseImpl.getMoviesByName("Teste")

        //Then
        movieListFlow.test {
            assertEquals(searchDomain, expectItem())
            expectComplete()
        }
    }

    @Test
    fun `getMoviesByName should throw Error when movie name length is bigger then 2 and repository return error`() = runBlockingTest {
        val error = Exception()
        //Given
        coEvery {
            movieListRepository.getMoviesByName(any())
        } returns flow { throw error }

        //When
        val movieListFlow = movieListUseCaseImpl.getMoviesByName("Teste")

        //Then
        movieListFlow.test {
            assertEquals(error, expectError())
        }
    }

    @Test
    fun `getMoviesByName should throw IllegalArgumentException when movie name length is less then 2`() = runBlockingTest {
        //When
        val movieListFlow = movieListUseCaseImpl.getMoviesByName("Te")

        //Then
        movieListFlow.test {
            val error: Throwable = expectError()
            assertThat(error, IsInstanceOf(IllegalArgumentException::class.java))
        }
    }

}