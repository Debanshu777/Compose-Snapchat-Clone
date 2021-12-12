package com.debanshu777.snapchatUIComposeClone.common.components

import android.content.res.Configuration
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun AutoSizeText(
    modifier:Modifier=Modifier,
    factor: Float=1f,
    text: String,
    textColor: Color,
    fontWeight:FontWeight=FontWeight.Normal,
    textAlign:TextAlign=TextAlign.Start,
    textStyle: TextStyle,
    configuration: Configuration
    ) {
    Text(
        text,
        modifier,
        fontWeight=fontWeight,
        color=textColor,
        textAlign=textAlign,
        fontSize=textStyle.fontSize*(configuration.fontScale*factor),
        softWrap = false,
    )
}