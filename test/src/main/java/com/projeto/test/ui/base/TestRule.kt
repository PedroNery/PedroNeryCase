package com.projeto.test.ui.base

import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockWebServer
import org.junit.rules.ExternalResource
import org.junit.rules.RuleChain
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module
import org.koin.test.KoinTest

const val PROPERTY_BASE_URL_LOCAL_TEST = "baseUrl"

open class TestRule(
    private val ruleChain: RuleChain
) : TestRule, KoinTest {

    val mockWebServer = MockWebServer()

    override fun apply(base: Statement?, description: Description?): Statement {
        return ruleChain
            .around(mockWebServer)
            .around(StartKoinRule())
            .apply(base, description)
    }

    fun addMockDispatcher(dispatcher: Dispatcher) {
        mockWebServer.dispatcher = dispatcher
    }

    fun loadKoinModules(block: MutableList<Module>.() -> Unit) {
        mutableListOf<Module>().apply(block).run {
            loadKoinModules(this)
        }
    }

    private inner class StartKoinRule : ExternalResource() {
        override fun before() {
            super.before()
            stopKoin()
            startKoin {
                properties(
                    mapOf(
                        PROPERTY_BASE_URL_LOCAL_TEST to mockWebServer.url("/").toString()
                    )
                )
            }
        }

        override fun after() {
            super.after()
            mockWebServer.shutdown()
            stopKoin()
        }
    }
}