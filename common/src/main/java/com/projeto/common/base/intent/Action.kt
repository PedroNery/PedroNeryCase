package com.projeto.pedronerycase.base.intent

import androidx.lifecycle.LiveData
import com.projeto.pedronerycase.base.livedata.OneShotLiveData
import com.projeto.common.base.viewmodel.ViewModelPlugins

class Action<Action : UIAction> {

    private val _action: OneShotLiveData<Action> = ViewModelPlugins.factory.createOneShotLiveData()
    val action: LiveData<Action> = _action

    fun sendAction(action: () -> Action) {
        _action.value = action()
    }

}