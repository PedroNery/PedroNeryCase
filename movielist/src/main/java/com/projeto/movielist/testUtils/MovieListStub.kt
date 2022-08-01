package com.projeto.movielist.testUtils

import com.projeto.movielist.model.movie.MovieResumed
import com.projeto.movielist.model.search.SearchResponse

internal object MovieListStub {

    val movieListStub = SearchResponse(
        totalResults = "2",
        response = true,
        search = listOf(
            MovieResumed(
                title = "Avatar",
                year = "2009",
                imdbID = "tt0499549",
                type = "movie",
                poster = "https://m.media-amazon.com/images/M/MV5BZDA0OGQxNTItMDZkMC00N2UyLTg3MzMtYTJmNjg3Nzk5MzRiXkEyXkFqcGdeQXVyMjUzOTY1NTc@._V1_SX300.jpg"
            ),
            MovieResumed(
                title = "Avatar: The Last Airbender",
                year = "2005–2008",
                imdbID = "tt0417299",
                type = "series",
                poster = "https://m.media-amazon.com/images/M/MV5BODc5YTBhMTItMjhkNi00ZTIxLWI0YjAtNTZmOTY0YjRlZGQ0XkEyXkFqcGdeQXVyODUwNjEzMzg@._V1_SX300.jpg"
            )
        ),
        error = null
    )

    val emptyStub = SearchResponse(
        totalResults = null,
        response = false,
        search = null,
        error = "Movie not found!"
    )

    val unknownApiKey = SearchResponse(
        totalResults = null,
        response = false,
        search = null,
        error = "Invalid API key!"
    )

    val unknownAPI = SearchResponse(
        totalResults = null,
        response = false,
        search = null,
        error = "Incorrect IMDb ID."
    )

}