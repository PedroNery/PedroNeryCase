package com.projeto.test.ui.base

import com.projeto.test.integration.MockDispatcher
import com.projeto.test.integration.startOn
import com.projeto.test.ui.robot.RobotArrangement
import org.koin.core.module.Module
import org.koin.dsl.module

interface BaseTest<R : RobotArrangement<*>> {
    val rule: InstrumentationTestRule
    fun launchWith(robot: R)
}

inline fun <reified R : RobotArrangement<*>> BaseTest<R>.setupRobot(
    noinline block: (R.() -> Unit)? = null
): R {
    val robot: R = R::class.java.newInstance().apply(block ?: {})
    launchWith(robot)
    return robot
}

fun <R : RobotArrangement<*>> BaseTest<R>.mockApiWith(
    dispatcher: MockDispatcher
) = dispatcher startOn rule.mockWebServer

fun <R : RobotArrangement<*>> BaseTest<R>.loadKoinModule(moduleBlock: Module.() -> Unit) {
    rule.loadKoinModules {
        add(module { moduleBlock })
    }
}