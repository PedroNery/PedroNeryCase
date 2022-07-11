package com.projeto.teste.launcher.viewmodel

import androidx.lifecycle.viewModelScope
import com.projeto.common.base.viewmodel.ActionViewModel
import com.projeto.launcher.action.LauncherAction
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LauncherViewModel() : ActionViewModel<LauncherAction>() {

    init {
        startLauncherCount()
    }

    private fun startLauncherCount(){
        viewModelScope.launch {
            delay(3000)
            setAction { LauncherAction.NavigateToMovieList }
        }
    }

}