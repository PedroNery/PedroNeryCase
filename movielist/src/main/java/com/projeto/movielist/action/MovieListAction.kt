package com.projeto.movielist.action

import com.projeto.pedronerycase.base.intent.UIAction

sealed class MovieListAction : UIAction {
    object NavigateToMovieDetail : UIAction
}