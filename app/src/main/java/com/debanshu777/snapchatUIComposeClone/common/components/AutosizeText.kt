package com.debanshu777.snapchatUIComposeClone.common.components

import android.content.res.Configuration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

/**
 * Custom Element Auto size text
 *
 * @param modifier
 * @param factor
 * @param text
 * @param textColor
 * @param fontWeight
 * @param textAlign
 * @param textStyle
 * @param configuration
 */
@Composable
fun AutoSizeText(
    modifier: Modifier = Modifier,
    factor: Float = 1f,
    text: String,
    textColor: Color,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Start,
    textStyle: TextStyle,
    configuration: Configuration
) {
    Text(
        text,
        modifier,
        fontWeight = fontWeight,
        color = textColor,
        textAlign = textAlign,
        fontSize = textStyle.fontSize * (configuration.fontScale * factor),
        softWrap = false,
    )
}
