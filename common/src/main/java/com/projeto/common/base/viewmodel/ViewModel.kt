package com.projeto.pedronerycase.base.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.projeto.pedronerycase.base.intent.UIAction
import com.projeto.pedronerycase.base.intent.UIState

abstract class ViewModel<State : UIState, Action : UIAction>(
    initialState : State
) : ViewModel() {

    private val viewModelState = com.projeto.pedronerycase.base.intent.State(initialState)
    private val viewModelAction = com.projeto.pedronerycase.base.intent.Action<Action>()

    val state: LiveData<State> = viewModelState.state
    val action: LiveData<Action> = viewModelAction.action

    protected fun setState(state: (State) -> State) {
        viewModelState.setState(state)
    }

    protected fun sendAction(action: () -> Action) {
        viewModelAction.sendAction(action)
    }

}