package com.projeto.test.integration

import okhttp3.mockwebserver.MockResponse

interface ResponseBuilder {
    fun build(): MockResponse
}