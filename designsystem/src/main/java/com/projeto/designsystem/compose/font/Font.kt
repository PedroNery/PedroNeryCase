package com.projeto.designsystem.compose.font

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.projeto.designsystem.R

val fonts = FontFamily(
    Font(R.font.font_case, FontWeight.Normal),
    Font(R.font.font_regular, FontWeight.Medium),
    Font(R.font.font_light, FontWeight.Light),
    Font(R.font.font_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.font_bold, FontWeight.Bold),
    Font(R.font.font_bold_italic, FontWeight.Bold, FontStyle.Italic)
)