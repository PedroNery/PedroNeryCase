package com.projeto.movielist.model.search

fun SearchResponse.toDomain(): SearchDomain {
    return SearchDomain(
        response = this.response,
        search = this.search,
        totalResults = this.totalResults,
        error = this.error
    )
}

fun SearchDomain.toDataUi(): SearchDataUI {
    return SearchDataUI(
        response = this.response,
        search = this.search,
        error = this.error
    )
}