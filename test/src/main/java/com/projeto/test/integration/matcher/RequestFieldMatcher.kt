package com.projeto.test.integration.matcher

import okhttp3.mockwebserver.RecordedRequest

interface RequestFieldMatcher {
    fun matches(request: RecordedRequest, order: Int): Boolean
    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
}