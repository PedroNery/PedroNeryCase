package com.projeto.test.integration

import com.projeto.test.integration.matcher.RequestMatcher

data class MockRequest(
    val matcher: RequestMatcher,
    val response: ResponseBuilder
)
