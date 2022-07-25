package com.projeto.test.integration.matcher

import okhttp3.mockwebserver.RecordedRequest

data class OrderMatcher(
    val expectedOrder: Int
) : UniqueRequestFieldMatcher {

    init {
        if (expectedOrder < 0) throw RequestMatcherException("RequesMatcher Order has to bem >= 0")
    }

    override fun matches(request: RecordedRequest, order: Int): Boolean {
        return expectedOrder == order
    }

    override fun toString(): String {
        return "order = $expectedOrder"
    }

}
