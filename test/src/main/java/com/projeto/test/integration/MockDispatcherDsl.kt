package com.projeto.test.integration

import com.projeto.test.integration.matcher.*
import okhttp3.mockwebserver.MockWebServer
import java.net.HttpURLConnection

private const val HTTP_ERROR_CODE = HttpURLConnection.HTTP_NOT_FOUND

// Dispatcher
fun dispatcherWithMocks(
    inOrder: Boolean = false,
    mocks: MutableList<MockRequest>.() -> Unit
): MockDispatcher {
    val defaultResponse: ResponseBuilder = DefaultResponseBuilder(responseCode = HTTP_ERROR_CODE)
    val requests = mutableListOf<MockRequest>().apply(mocks)
    return MockDispatcher(requests, defaultResponse, inOrder)
}

infix fun MockDispatcher.startOn(mockWebServer: MockWebServer) {
    startOn(mockWebServer)
}

// Request
infix fun MutableList<MockRequest>.mock(request: () -> MockRequest) {
    add(request.invoke())
}

infix fun String.with(response: ResponseBuilder): MockRequest {
    val matcher = RequestMatcher(this)
    return MockRequest(matcher, response)
}

// Response
typealias response = DefaultResponseBuilder