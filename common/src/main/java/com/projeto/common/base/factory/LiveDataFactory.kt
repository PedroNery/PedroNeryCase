package com.projeto.common.base.factory

import androidx.lifecycle.MutableLiveData
import com.projeto.pedronerycase.base.livedata.OneShotLiveData
import com.projeto.pedronerycase.base.intent.UIAction
import com.projeto.pedronerycase.base.intent.UIState

interface LiveDataFactory {

    fun<T : UIState> createMutableLiveData(initialState: T): MutableLiveData<T>

    fun<T : UIAction> createOneShotLiveData(): OneShotLiveData<T>

}