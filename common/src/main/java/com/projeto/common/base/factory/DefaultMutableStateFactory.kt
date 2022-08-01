package com.projeto.common.base.factory

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.projeto.pedronerycase.base.intent.UIAction
import com.projeto.pedronerycase.base.intent.UIState
import com.projeto.pedronerycase.base.livedata.OneShotLiveData

class DefaultMutableStateFactory : MutableStateFactory {

    override fun <T : UIState> createMutableState(initialState: T): MutableState<T> {
        return mutableStateOf(initialState)
    }

    override fun <T : UIAction> createOneShotLiveData() = OneShotLiveData<T>()

}