package com.projeto.common.base.viewmodel

import androidx.lifecycle.ViewModel
import com.projeto.pedronerycase.base.intent.UIAction
import com.projeto.pedronerycase.base.intent.Action

abstract class ActionViewModel<Action : UIAction> : ViewModel() {

    private val actionAttribute = Action<Action>()

    fun getAction() = actionAttribute.action

    fun setAction(action: () -> Action) {
        actionAttribute.sendAction(action)
    }
}