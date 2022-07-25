package com.projeto.test.ui.base

import android.app.Activity
import com.projeto.test.ui.robot.RobotArrangement

interface ActivityTest<R : RobotArrangement<*>> : BaseTest<R> {

    override val rule: ActivityTestRule<out Activity>

    override fun launchWith(robot: R) {
        rule.beforeActivityLaunch {
            robot.beforeAction()
        }.putBundles {
            robot.setupBundleForViewUnderTest(this)
        }.launchActivity()

        if (robot is ActivityRobotArrangement<*>) {
            rule.afterActivityOpen(robot::afterActivityOpen)
        }
    }
}

inline val <reified R : RobotArrangement<*>> ActivityTest<R>.onActivity: R
    get() = setupRobot()

inline fun <reified R : RobotArrangement<*>> ActivityTest<R>.onActivity(
    noinline block: R.() -> Unit
): R = setupRobot(block)