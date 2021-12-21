package com.richard.edvora.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.richard.edvora.R

// Set of Material typography styles to start with
val spfFont = Font(
    R.font.spf_pro_display
)

val spfFontFamily = FontFamily(
    spfFont
)

val Typography = Typography(
    body1 = TextStyle(
        fontFamily = spfFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = spfFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = spfFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    defaultFontFamily = spfFontFamily

)