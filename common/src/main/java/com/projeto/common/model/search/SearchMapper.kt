package com.projeto.common.model.search

fun SearchResponse.toDomain(): SearchDomain {
    return SearchDomain(
        response = this.response,
        search = this.search,
        totalResults = this.totalResults
    )
}

fun SearchDomain.toDataUi(): SearchDataUI {
    return SearchDataUI(
        response = this.response,
        search = this.search
    )
}