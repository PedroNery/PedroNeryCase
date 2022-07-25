package com.projeto.test.integration

import okhttp3.mockwebserver.MockResponse
import java.net.HttpURLConnection

private const val EMPTY_CODE = "{}"

class DefaultResponseBuilder(
    val responseBodyFilePath: String? = null,
    val responseCode: Int = HttpURLConnection.HTTP_OK
) : ResponseBuilder {

    private var resourceReader = ReadFile()

    override fun build(): MockResponse {
        return MockResponse().setResponseCode(responseCode)
            .setBody(buildBody())
    }

    private fun buildBody(): String {
        return responseBodyFilePath?.let {
            resourceReader(it)
        } ?: run {
            EMPTY_CODE
        }
    }
}