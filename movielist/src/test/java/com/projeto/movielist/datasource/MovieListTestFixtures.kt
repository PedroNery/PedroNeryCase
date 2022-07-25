package com.projeto.movielist.datasource

import com.projeto.test.integration.*

const val MOVIE_NAME_QUERY = "MOVIE_NAME_QUERY"
private const val MOVIE_LIST_API_ENDPOINT = "/?s=$MOVIE_NAME_QUERY"
private const val MOVIE_LIST_SEARCH_SUCCESS_RESPONSE = "searchresponse/movie_search_success_response.json"
private const val MOVIE_LIST_SEARCH_EMPTY_RESPONSE = "searchresponse/movie_search_not_found_response.json"
private const val MOVIE_LIST_SEARCH_INVALID_API_KEY_RESPONSE = "searchresponse/movie_search_invalid_api_key_response.json"
private const val MOVIE_LIST_SEARCH_UNKNOWN_API_RESPONSE = "searchresponse/movie_search_unknown_api_response.json"

val movieListSuccessResponse = dispatcherWithMocks {
    mock { MOVIE_LIST_API_ENDPOINT with response(MOVIE_LIST_SEARCH_SUCCESS_RESPONSE, 200) }
}

val movieListEmptyResponse = dispatcherWithMocks {
    mock { MOVIE_LIST_API_ENDPOINT with response(MOVIE_LIST_SEARCH_EMPTY_RESPONSE) }
}

val unknownApiKeyErrorResponse = dispatcherWithMocks {
    mock { MOVIE_LIST_API_ENDPOINT with response(MOVIE_LIST_SEARCH_INVALID_API_KEY_RESPONSE) }
}

val unknownAPIErrorResponse = dispatcherWithMocks {
    mock { MOVIE_LIST_API_ENDPOINT with response(MOVIE_LIST_SEARCH_UNKNOWN_API_RESPONSE) }
}