package com.projeto.designsystem.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.view.AccessibilityDelegateCompat
import androidx.core.view.ViewCompat
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat
import androidx.core.widget.TextViewCompat
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputLayout
import com.projeto.common.base.extensions.setMarginTop
import com.projeto.designsystem.R

class NewTextInputLayout @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : TextInputLayout(context, attributeSet, defStyle) {

    private val counterTextView: TextView? get() = findViewById(R.id.textinput_counter)
    private val helperTextView: TextView? get() = findViewById(R.id.textinput_helper_text)
    private val errorTextView: TextView? get() = findViewById(R.id.textinput_error)

    private val errorIconResId: Int = R.drawable.ic_text_input_error

    private var hasError: Boolean = false
    private var hasFocus: Boolean = false
    private var lastText: String? = null
    private var errorText: CharSequence? = null

    init {
        configAccessibilityDelegate()
    }

    private fun configAccessibilityDelegate() {
        ViewCompat.setAccessibilityDelegate(
            this,
            object : AccessibilityDelegateCompat() {
                override fun onInitializeAccessibilityNodeInfo(
                    host: View?,
                    info: AccessibilityNodeInfoCompat?
                ) {
                    info?.setTraversalBefore(errorTextView)
                    super.onInitializeAccessibilityNodeInfo(host, info)
                }
            }
        )
    }

    override fun setError(errorText: CharSequence?) {
        super.setError(errorText)
        this.errorText = errorText
        hasError = errorText?.isNotEmpty() == true || validateCounterLength()
        configBackgroundColor()
        configErrorText()
        errorTextView?.configErrorIcon(leftIcon = true)
    }

    override fun setErrorEnabled(enabled: Boolean) {
        super.setErrorEnabled(enabled)
        if (enabled.not()) hasError = validateCounterLength()
        configBackgroundColor()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        configHelperText()
        if (isCounterEnabled) configCounterText()

        editText?.let {
            it.setOnFocusChangeListener { _, hasFocus ->
                this.hasFocus = hasFocus
                configBackgroundColor()
            }

            it.doAfterTextChanged { editable ->
                if (editable?.toString() != lastText) {
                    lastText = editable?.toString()
                    hasError = errorText?.isNotEmpty() == true || validateCounterLength()
                    if (isCounterEnabled) counterTextView?.configErrorIcon(rightIcon = true)
                    configBackgroundColor()
                }
            }
        }
    }

    private fun configBackgroundColor() {
        boxBackgroundColor = when {
            hasError -> getColor(R.color.colorCritical)
            hasFocus -> getColor(R.color.colorLightPrimary)
            else -> getColor(R.color.grayscaleLight)
        }
    }

    private fun configErrorText() = errorTextView?.configTextView(removeLeftPadding = true)

    private fun configHelperText() = helperTextView?.removePadding(removeLeftPadding = true)

    private fun configCounterText() = counterTextView?.configTextView(removeRightPadding = true)

    private fun TextView.configErrorIcon(leftIcon: Boolean = false, rightIcon: Boolean = false) {
        TextViewCompat.setCompoundDrawablesRelativeWithIntrinsicBounds(
            this,
            errorIconResId.takeIf { leftIcon && hasError } ?: 0,
            0,
            errorIconResId.takeIf { rightIcon && hasError } ?: 0,
            0
        )
    }

    private fun TextView.removePadding(
        removeLeftPadding: Boolean = false,
        removeRightPadding: Boolean = false
    ) {
        val viewGroup = (parent as? ViewGroup)?.let {
            if (id == counterTextView?.id) it else it.parent as? ViewGroup
        }

        viewGroup?.let {
            it.setPadding(
                it.paddingLeft.takeUnless { removeLeftPadding } ?: 0,
                it.paddingTop,
                it.paddingRight.takeUnless { removeRightPadding } ?: 0,
                it.paddingBottom
            )
        }

        setMarginTop(context.resources.getDimensionPixelSize(R.dimen.spacing_01))
    }

    private fun TextView.configTextView(
        removeLeftPadding: Boolean = false,
        removeRightPadding: Boolean = false
    ) {
        compoundDrawablePadding = context.resources.getDimensionPixelSize(R.dimen.spacing_01)
        removePadding(removeLeftPadding, removeRightPadding)
    }

    private fun getColor(@ColorRes colorId: Int): Int = ContextCompat.getColor(context, colorId)

    private fun validateCounterLength(): Boolean =
        isCounterEnabled && (editText?.text?.length ?: 0) > counterMaxLength
}