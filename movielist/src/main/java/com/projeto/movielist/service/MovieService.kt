package com.projeto.movielist.service

import com.projeto.common.model.search.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("/")
    suspend fun getMoviesByName(@Query("s") name : String) : SearchResponse

}