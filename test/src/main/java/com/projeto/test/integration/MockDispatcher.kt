package com.projeto.test.integration

import com.projeto.test.integration.matcher.ConflictingMatcherException
import com.projeto.test.integration.matcher.OrderMatcher
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okhttp3.mockwebserver.RecordedRequest
import java.util.concurrent.atomic.AtomicInteger

class MockDispatcher internal constructor(
    private val requests: List<MockRequest>,
    private val defaultResponse: ResponseBuilder,
    inOrder: Boolean = false
) {

    init {
        if (inOrder) {
            addOrderToRequests()
        } else {
            checkConflictingRequests()
        }
    }

    private fun addOrderToRequests() {
        requests.forEachIndexed { index, request ->
            request.matcher.addMatcher(OrderMatcher(index))
        }
    }

    private fun checkConflictingRequests() {
        requests.forEachIndexed { index, request ->
            if (index == requests.lastIndex) return
            requests.listIterator(index + 1).forEach { other ->
                if (request.matcher.contains(other.matcher)) {
                    throw ConflictingMatcherException(request.matcher, other.matcher)
                } else if (other.matcher.contains(request.matcher)) {
                    throw ConflictingMatcherException(other.matcher, request.matcher)
                }
            }
        }
    }

    internal fun startOn(mockWebServer: MockWebServer) {
        mockWebServer.dispatcher = object : Dispatcher() {
            private val order = AtomicInteger(0)

            override fun dispatch(request: RecordedRequest): MockResponse {
                val order = order.getAndIncrement()
                val builder = requests.firstOrNull { it.matcher.matches(request, order) }
                return (builder?.response ?: defaultResponse).build()
            }
        }
    }
}