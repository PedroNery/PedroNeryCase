package com.projeto.test.ui.assertion

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText

fun checkExactTextExpected(resId: Int, expected: String){
    onView(withId(resId)).check(matches(withText(expected)))
}