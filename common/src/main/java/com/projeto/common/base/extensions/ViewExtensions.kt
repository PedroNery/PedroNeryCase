package com.projeto.common.base.extensions

import android.view.View
import android.view.ViewGroup

fun View.setMarginTop(padding: Int) {
    val params = this.layoutParams as ViewGroup.MarginLayoutParams
    params.topMargin = padding
    layoutParams = params
}