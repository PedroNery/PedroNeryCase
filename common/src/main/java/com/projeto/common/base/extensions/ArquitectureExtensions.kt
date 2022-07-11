package com.projeto.common.base.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.projeto.common.base.viewmodel.ActionViewModel
import com.projeto.common.base.viewmodel.StateViewModel
import com.projeto.pedronerycase.base.intent.UIAction
import com.projeto.pedronerycase.base.intent.UIState
import com.projeto.pedronerycase.base.viewmodel.ViewModel

inline fun <reified State : UIState, reified Action : UIAction> AppCompatActivity.onStateChange(
    viewModel: ViewModel<State, Action>,
    crossinline handleEvents: (State) -> Unit
) {
    viewModel.state.observe(this, Observer { event -> handleEvents(event as State) })
}

inline fun <reified State : UIState, reified Action : UIAction> AppCompatActivity.onAction(
    viewModel: ViewModel<State, Action>,
    crossinline handleEvents: (Action) -> Unit
) {
    viewModel.action.observe(this, Observer { event -> handleEvents(event as Action) })
}

inline fun <reified State : UIState> AppCompatActivity.onStateChange(
    viewModel: StateViewModel<State>,
    crossinline handleEvents: (State) -> Unit
) {
    viewModel.getState().observe(this, Observer { event -> handleEvents(event as State) })
}

inline fun <reified Action : UIAction> AppCompatActivity.onAction(
    viewModel: ActionViewModel<Action>,
    crossinline handleEvents: (Action) -> Unit
) {
    viewModel.getAction().observe(this, Observer { event -> handleEvents(event as Action) })
}