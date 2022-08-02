package com.projeto.designsystem.compose.font

import androidx.compose.material.Typography

private val defaultTypography = Typography()
val Typography = Typography(
    h1 = defaultTypography.h1.copy(fontFamily = fonts),
    h2 = defaultTypography.h2.copy(fontFamily = fonts),
    h3 = defaultTypography.h3.copy(fontFamily = fonts),
    h4 = defaultTypography.h4.copy(fontFamily = fonts),
    h5 = defaultTypography.h5.copy(fontFamily = fonts),
    h6 = defaultTypography.h6.copy(fontFamily = fonts),
    subtitle1 = defaultTypography.subtitle1.copy(fontFamily = fonts),
    subtitle2 = defaultTypography.subtitle2.copy(fontFamily = fonts),
    body1 = defaultTypography.body1.copy(fontFamily = fonts),
    body2 = defaultTypography.body2.copy(fontFamily = fonts),
    button = defaultTypography.button.copy(fontFamily = fonts),
    caption = defaultTypography.caption.copy(fontFamily = fonts),
    overline = defaultTypography.overline.copy(fontFamily = fonts),
)