package com.projeto.common.model.movie

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Year")
    val year: String,
    @SerializedName("imdbId")
    val imdbID: String
)