package com.projeto.pedronerycase.base.intent

import androidx.lifecycle.LiveData
import com.projeto.pedronerycase.base.viewmodel.ViewModelPlugins

class State<State : UIState>(initialState: State) {

    private val _state = ViewModelPlugins.factory.createMutableLiveData(initialState)
    val state: LiveData<State> = _state

    fun setState(state: (State) -> State){
        _state.value = state(_state.value!!)
    }
}