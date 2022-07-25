package com.projeto.test.integration.matcher

sealed class HttpMethod(val value: String) {
    object GET : HttpMethod("GET")
    object HEAD : HttpMethod("HEAD")
    object POST : HttpMethod("POST")
    object PUT : HttpMethod("PUT")
    object DELETE : HttpMethod("DELETE")
    object OPTIONS : HttpMethod("OPTIONS")
    object PATCH : HttpMethod("PATCH")
    data class HTTP(val method: String, val hasBody: Boolean = false) : HttpMethod(method)
}