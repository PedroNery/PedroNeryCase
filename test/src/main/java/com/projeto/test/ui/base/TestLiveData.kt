package com.projeto.test.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.test.platform.app.InstrumentationRegistry

class TestLiveData<T> : MutableLiveData<T> {
    constructor() : super()
    constructor(initialValue: T) : super(initialValue)

    private val testThread = Thread.currentThread()

    override fun setValue(value: T?) {
        if (testThread == Thread.currentThread()) {
            setValueOnMainThread(value)
        } else {
            super.setValue(value)
        }
    }

    fun setValueOnMainThread(value: T?) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            super.setValue(value)
        }
    }
}