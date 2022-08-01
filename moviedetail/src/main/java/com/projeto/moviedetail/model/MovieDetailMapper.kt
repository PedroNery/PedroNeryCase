package com.projeto.moviedetail.model

fun MovieDetail.toDomain(): MovieDetailDomain {
    return MovieDetailDomain(
        poster = this.poster,
        title = this.title,
        type = this.type,
        year = this.year,
        released = this.released,
        runtime = this.runtime,
        genre = this.genre,
        director = this.director,
        actors = this.actors,
        plot = this.plot,
        imdbRating = this.imdbRating
    )
}

fun MovieDetailDomain.toDataUI(): MovieDetailDataUI {
    return MovieDetailDataUI(
        poster = this.poster,
        title = this.title,
        type = this.type,
        year = this.year,
        released = this.released,
        runtime = this.runtime,
        genre = this.genre,
        director = this.director,
        actors = this.actors,
        plot = this.plot,
        imdbRating = this.imdbRating
    )
}