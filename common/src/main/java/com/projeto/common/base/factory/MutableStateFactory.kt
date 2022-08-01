package com.projeto.common.base.factory

import androidx.compose.runtime.MutableState
import com.projeto.pedronerycase.base.intent.UIAction
import com.projeto.pedronerycase.base.intent.UIState
import com.projeto.pedronerycase.base.livedata.OneShotLiveData

interface MutableStateFactory {

    fun<T : UIState> createMutableState(initialState: T): MutableState<T>

    fun<T : UIAction> createOneShotLiveData(): OneShotLiveData<T>

}