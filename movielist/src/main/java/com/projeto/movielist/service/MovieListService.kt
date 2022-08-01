package com.projeto.movielist.service

import com.projeto.movielist.model.search.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieListService {

    @GET("/")
    suspend fun getMoviesByName(@Query("s") name : String) : SearchResponse

}