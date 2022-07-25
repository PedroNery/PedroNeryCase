package com.projeto.test.ui.robot

import android.os.Bundle
import com.projeto.test.ui.assertion.RobotAssertion

interface RobotArrangement<T : RobotAction<*>> {
    fun beforeAction() = Unit
    fun setupBundleForViewUnderTest(bundle: Bundle) = Unit
}

inline infix fun <reified T : RobotAction<*>> RobotArrangement<T>.withAction(
    block: T.() -> Unit
): T {
    return T::class.java.newInstance().apply(block)
}

inline infix fun <reified A : RobotAction<S>, reified S : RobotAssertion> RobotArrangement<A>.check(
    block: S.() -> Unit
): S {
    return withAction { } check (block)
}