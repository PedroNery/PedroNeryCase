package com.projeto.teste.launcher.action

import com.projeto.pedronerycase.base.intent.UIAction

sealed class LauncherAction : UIAction {
    object NavigateToMovieList : LauncherAction()
}