package com.projeto.common.base.viewmodel

import androidx.annotation.VisibleForTesting
import com.projeto.common.base.factory.DefaultMutableStateFactory
import com.projeto.common.base.factory.MutableStateFactory

object ViewModelComposePlugins {

    var factory: MutableStateFactory = DefaultMutableStateFactory()
        private set

    @VisibleForTesting
    fun setFactory(factory: MutableStateFactory){
        ViewModelComposePlugins.factory = factory
    }

}