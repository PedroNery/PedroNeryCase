package com.projeto.movielist.activity

import com.projeto.test.ui.action.ViewActions.performClearText
import com.projeto.movielist.R
import com.projeto.test.ui.action.ViewActions.performType
import com.projeto.test.ui.robot.RobotAction

class MovieListActionRobot : RobotAction<MovieListAssertionRobot> {

    fun inputMovieName(value: String){
        performClearText(R.id.etSearchMovie)
        performType(R.id.etSearchMovie, value)
    }

}