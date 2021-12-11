package com.debanshu777.snapchatUIComposeClone.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.debanshu777.snapchatUIComposeClone.R

// Set of Material typography styles to start with
val Typography = Typography(
    defaultFontFamily = FontFamily(Font(R.font.avenir_next_lt_pro_lt)),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    subtitle1 =TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)