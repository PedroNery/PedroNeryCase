package com.projeto

import android.app.Application
import com.projeto.common.koin.aware.KoinLifecycleCallbacks
import com.projeto.common.koin.KoinAppDeclarationProvider
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        registerActivityLifecycleCallbacks(KoinLifecycleCallbacks())
        startKoin(appDeclaration = KoinAppDeclarationProvider.get(this))
    }

}