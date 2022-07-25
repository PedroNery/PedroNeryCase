package com.projeto.test.ui.robot

import com.projeto.test.ui.assertion.RobotAssertion

interface RobotAction<T : RobotAssertion>

inline infix fun <reified T : RobotAssertion> RobotAction<T>.check(
    block: T.() -> Unit
): T {
    return T::class.java.newInstance().apply(block)
}