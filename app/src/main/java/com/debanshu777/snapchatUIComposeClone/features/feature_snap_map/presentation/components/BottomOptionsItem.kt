package com.debanshu777.snapchatUIComposeClone.features.feature_snap_map.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.debanshu777.snapchatUIComposeClone.common.components.AutoSizeText
import com.debanshu777.snapchatUIComposeClone.common.utils.ThemeColors

/**
 * Bottom option item
 *
 * @param text
 * @param imageResource
 */
@Composable
fun BottomOptionItem(
    text: String,
    imageResource: Int,
) {
    val configuration = LocalConfiguration.current
    Box(
        modifier = Modifier
            .size(120.dp)
    ) {
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .align(Alignment.BottomCenter)
                .background(color = Color.White)
        ) {
            Image(
                modifier = Modifier
                    .size(35.25.dp).padding(top = 5.dp)
                    .align(Alignment.TopCenter)
                    .clip(CircleShape),
                painter = painterResource(imageResource),
                contentDescription = "Content description for visually bitmoji"
            )
        }
        Box(
            modifier = Modifier
                .height(18.dp)
                .width(70.dp)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(10.dp))
                .background(color = Color.White)
        ) {
            AutoSizeText(
                modifier = Modifier.align(Alignment.TopCenter).padding(1.dp),
                factor = 0.60f,
                text = text,
                textColor = ThemeColors.DARK_TINT_TEXT,
                fontWeight = FontWeight.W600,
                textStyle = TextStyle(fontSize = 20.sp),
                configuration = configuration
            )
        }
    }
}
