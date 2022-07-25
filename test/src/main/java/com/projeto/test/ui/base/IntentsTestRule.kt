package com.projeto.test.ui.base

import androidx.test.espresso.intent.Intents
import org.junit.rules.ExternalResource

class IntentsTestRule : ExternalResource() {

    override fun before() {
        super.before()
        Intents.init()
    }

    override fun after() {
        super.after()
        Intents.release()
    }

}