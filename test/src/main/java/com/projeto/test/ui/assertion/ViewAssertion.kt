package com.projeto.test.ui.assertion

import android.view.View
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import com.projeto.test.ui.matcher.RecyclerViewMatchers.atPosition
import com.projeto.test.ui.matcher.RecyclerViewMatchers.itensCount
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Matcher


object ViewAssertion {

    fun checkViewIsDisplayed(resId: Int) {
        onView(withId(resId)).check(matches(isDisplayed()))
    }

    fun checkViewIsNotDisplayed(resId: Int) {
        onView(withId(resId)).check(matches(not(isDisplayed())))
    }

    fun checkSizeRecyclerView(resId: Int, size: Int){
        onView(allOf(withId(resId)))
            .check(itensCount(size))
    }

    fun checkRecyclerViewItem(resId: Int, position: Int, withMatcher: Matcher<View>) {
        onView(withId(resId))
            .perform(scrollToPosition<RecyclerView.ViewHolder>(position))
            .check(matches(atPosition(position, hasDescendant(withMatcher))))
    }

}