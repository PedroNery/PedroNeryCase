package com.projeto.test.integration.matcher

class ConflictingMatcherException(
    matcher: RequestMatcher,
    contained: RequestMatcher
) : Exception(
    "$contained is contained by $matcher./n" +
            "If the intention is checking successive calls to the same endpoint, " +
            "use dispatcherWithMocks(inOrder = true)"
)