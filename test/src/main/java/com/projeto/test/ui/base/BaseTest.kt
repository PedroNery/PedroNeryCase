package com.projeto.test.ui.base

import com.projeto.test.ui.robot.RobotArrangement

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