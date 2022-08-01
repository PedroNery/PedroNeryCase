package com.projeto.common.base.viewmodel

import androidx.lifecycle.ViewModel
import com.projeto.common.base.intent.ComposeState
import com.projeto.pedronerycase.base.intent.UIState

abstract class StateComposeViewModel<State : UIState>(initialState: State) : ViewModel() {

    private val stateAtribute = ComposeState(initialState)

    fun getState() = stateAtribute.state

    fun setState(state: (State) -> State) {
        stateAtribute.setState(state)
    }
}