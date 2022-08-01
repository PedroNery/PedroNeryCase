package com.projeto.moviedetail.model

import com.google.gson.annotations.SerializedName

data class MovieDetailDomain(
    val poster: String,
    val title: String,
    val type: String,
    val year: String,
    val released: String,
    val runtime: String,
    val genre: String,
    val director: String,
    val actors: String,
    val plot: String,
    val imdbRating: String
)
