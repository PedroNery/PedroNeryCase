package com.projeto.movielist.activity

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.projeto.test.ui.assertion.RobotAssertion
import com.projeto.test.ui.assertion.ViewAssertion.checkRecyclerViewItem
import org.hamcrest.Matcher
import com.projeto.movielist.R
import com.projeto.test.ui.assertion.ViewAssertion.checkSizeRecyclerView
import com.projeto.test.ui.assertion.ViewAssertion.checkViewIsDisplayed
import com.projeto.test.ui.assertion.ViewAssertion.checkViewIsNotDisplayed
import com.projeto.test.ui.assertion.checkExactTextExpected
import org.hamcrest.Matchers.allOf

class MovieListAssertionRobot : RobotAssertion {

    fun messageErrorOnTextViewIs(value: String) {
        checkExactTextExpected(R.id.tvError, value)
    }

    fun checkSizeMovieRecyclerView(size: Int) {
        checkSizeRecyclerView(
            R.id.rvMovieList,
            size
        )
    }

    fun checkLoadingIsDisplayed(isDisplayed: Boolean) {
        if(isDisplayed)
            checkViewIsDisplayed(R.id.loading)
        else
            checkViewIsNotDisplayed(R.id.loading)
    }

    fun checkListIsDisplayed(isDisplayed: Boolean) {
        if(isDisplayed)
            checkViewIsDisplayed(R.id.rvMovieList)
        else
            checkViewIsNotDisplayed(R.id.rvMovieList)
    }

    fun checkErrorIsDisplayed(isDisplayed: Boolean) {
        if(isDisplayed)
            checkViewIsDisplayed(R.id.tvError)
        else
            checkViewIsNotDisplayed(R.id.tvError)
    }

    fun labelAtPositionIs(position: Int, label: String) {
        assertAtMovieList(
            position,
            allOf(withId(R.id.tvMovieTitle), withText(label))
        )
    }

    private fun assertAtMovieList(position: Int, matcher: Matcher<View>) {
        checkRecyclerViewItem(
            R.id.rvMovieList,
            position,
            matcher
        )
    }

}