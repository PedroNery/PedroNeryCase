package com.projeto.test.integration.matcher

import okhttp3.mockwebserver.RecordedRequest

data class PathMatcher(
    val path: String
) : UniqueRequestFieldMatcher {

    override fun matches(request: RecordedRequest, order: Int): Boolean {
        return path == request.path
    }

    override fun toString(): String {
        return "path = $path"
    }
}
