package com.projeto.test.ui.action

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId

object ViewActions {

    fun performClearText(@IdRes resId: Int) {
        onView(withId(resId)).perform(clearText())
    }

    fun performType(@IdRes resId: Int, text: String) {
        onView(withId(resId)).perform(typeText(text))
        Espresso.closeSoftKeyboard()
    }

}