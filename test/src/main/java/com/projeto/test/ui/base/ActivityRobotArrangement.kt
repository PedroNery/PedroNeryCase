package com.projeto.test.ui.base

import android.app.Activity
import com.projeto.test.ui.robot.RobotAction
import com.projeto.test.ui.robot.RobotArrangement

interface ActivityRobotArrangement<T : RobotAction<*>> : RobotArrangement<T> {
    fun afterActivityOpen(view: Activity) = Unit
}