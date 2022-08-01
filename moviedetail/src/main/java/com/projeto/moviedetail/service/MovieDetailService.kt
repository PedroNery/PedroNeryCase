package com.projeto.moviedetail.service

import com.projeto.moviedetail.model.MovieDetail
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDetailService {

    @GET("/")
    suspend fun getMovieDetailById(@Query("i") id: String) : MovieDetail

}