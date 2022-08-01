package com.projeto.common.base.intent

import androidx.compose.runtime.State
import com.projeto.common.base.viewmodel.ViewModelComposePlugins
import com.projeto.pedronerycase.base.intent.UIState

class ComposeState<StateUI : UIState>(initialState: StateUI) {

    private val _state = ViewModelComposePlugins.factory.createMutableState(initialState)
    val state: State<StateUI> = _state

    fun setState(state: (StateUI) -> StateUI){
        _state.value = state(_state.value)
    }
}