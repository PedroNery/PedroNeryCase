package com.projeto.test.integration.matcher

import okhttp3.mockwebserver.RecordedRequest

class RequestMatcher(
    path: String
) {
    private val set = HashSet<RequestFieldMatcher>()
    private val registeredUniqueFields = HashSet<Class<*>>()

    init {
        set.add(PathMatcher(path))
    }

    fun contains(other: RequestMatcher) = set.containsAll(other.set)

    fun matches(request: RecordedRequest, order: Int): Boolean {
        return set.all { it.matches(request, order) }
    }

    fun addMatcher(matcher: RequestFieldMatcher) {
        if (matcher is UniqueRequestFieldMatcher) {
            if (matcher.isTypeRegistered()) {
                val message = "RequestMatcher of type " +
                        "${matcher::class.java.simpleName} " +
                        "cannot be reassigned."
                throw RequestMatcherException(message)
            } else {
                matcher.registerType()
            }
        }

        set.add(matcher)
    }

    private fun UniqueRequestFieldMatcher.isTypeRegistered(): Boolean {
        return registeredUniqueFields.contains(this::class.java)
    }

    private fun UniqueRequestFieldMatcher.registerType(): Boolean {
        return registeredUniqueFields.add(this::class.java)
    }

    override fun toString(): String {
        return "RequestMatcher${set.map { "$it" }}"
    }
}