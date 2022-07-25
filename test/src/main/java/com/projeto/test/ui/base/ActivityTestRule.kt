package com.projeto.test.ui.base

import android.app.Activity
import android.app.Instrumentation
import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider

@Suppress("LateinitUsage")
class ActivityTestRule<T : Activity>(
    val activityClass: Class<T>
) : InstrumentationTestRule() {

    private var setupBeforeActivityOpen: () -> Unit = {}
    private var setupBundleActivity: Bundle = Bundle()
    private lateinit var activityScenario: ActivityScenario<T>
    @Deprecated("Utilize o método afterActivityOpen para ter acesso a activity, de forma segura")
    var activity: Activity? = null

    fun beforeActivityLaunch(block: () -> Unit) = apply {
        setupBeforeActivityOpen = block
    }

    fun putBundles(block: Bundle.() -> Unit) = apply {
        block.invoke(setupBundleActivity)
    }

    fun launchActivity() {
        setupBeforeActivityOpen()

        val intent = Intent().apply {
            component = ComponentName(ApplicationProvider.getApplicationContext(), activityClass)
            putExtras(setupBundleActivity)
        }

        activityScenario = ActivityScenario.launch<T>(intent)

        activityScenario.onActivity { activity ->
            this.activity = activity
        }
    }

    fun afterActivityOpen(action: (T) -> Unit) {
        activityScenario.onActivity(action)
    }

    fun getActivityState(): Lifecycle.State = activityScenario.state

    fun getActivityResult(): Instrumentation.ActivityResult? = activityScenario.result

    fun closeActivity() {
        activityScenario.close()
    }
}