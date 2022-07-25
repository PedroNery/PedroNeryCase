package com.projeto.test.ui.base

import org.junit.rules.RuleChain

open class InstrumentationTestRule : TestRule(addRules())

private fun addRules() =
    RuleChain
        .outerRule(IntentsTestRule())