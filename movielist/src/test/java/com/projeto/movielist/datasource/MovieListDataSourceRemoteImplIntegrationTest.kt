package com.projeto.movielist.datasource

import androidx.test.filters.MediumTest
import com.projeto.movielist.service.MovieListService
import com.projeto.test.integration.createRetrofit
import com.projeto.test.integration.startOn
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.Test
import org.junit.Assert.assertEquals
import app.cash.turbine.test
import com.projeto.movielist.testUtils.MovieListStub
import org.junit.After
import kotlin.time.ExperimentalTime

@MediumTest
@ExperimentalTime
class MovieListDataSourceRemoteImplIntegrationTest {

    private val mockWebServer = MockWebServer()
    private val baseUrl: String = mockWebServer.url("/").toString()
    private val retrofit = createRetrofit(baseUrl)
    private val dataSource: MovieListDataSourceRemoteImpl = createDataSource()

    private fun createDataSource(): MovieListDataSourceRemoteImpl {
        val service = retrofit.create(MovieListService::class.java)
        return MovieListDataSourceRemoteImpl(service)
    }

    @Test
    fun `getMoviesByName when success Should return movieList`() {
        val stubMovieListQuery = MOVIE_NAME_QUERY
        val expectedResult = MovieListStub.movieListStub
        movieListSuccessResponse.startOn(mockWebServer)

        val response = dataSource.getMoviesByName(stubMovieListQuery)

        runBlocking {
            response.test {
                assertEquals(expectedResult, expectItem())
                expectComplete()
            }
        }
    }

    @Test
    fun `getMoviesByName when empty Should return Movie Not Found`() {
        val stubMovieListQuery = MOVIE_NAME_QUERY
        val expectedResult = MovieListStub.emptyStub
        movieListEmptyResponse.startOn(mockWebServer)

        val response = dataSource.getMoviesByName(stubMovieListQuery)

        runBlocking {
            response.test {
                assertEquals(expectedResult, expectItem())
                expectComplete()
            }
        }
    }

    @Test
    fun `getMoviesByName when API Key Invalid Should return Invalid API key!`() {
        val stubMovieListQuery = MOVIE_NAME_QUERY
        val expectedResult = MovieListStub.unknownApiKey
        unknownApiKeyErrorResponse.startOn(mockWebServer)

        val response = dataSource.getMoviesByName(stubMovieListQuery)

        runBlocking {
            response.test {
                assertEquals(expectedResult, expectItem())
                expectComplete()
            }
        }
    }

    @Test
    fun `getMoviesByName when API is Invalid Should return Incorrect IMDb ID`() {
        val stubMovieListQuery = MOVIE_NAME_QUERY
        val expectedResult = MovieListStub.unknownAPI
        unknownAPIErrorResponse.startOn(mockWebServer)

        val response = dataSource.getMoviesByName(stubMovieListQuery)

        runBlocking {
            response.test {
                assertEquals(expectedResult, expectItem())
                expectComplete()
            }
        }
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

}