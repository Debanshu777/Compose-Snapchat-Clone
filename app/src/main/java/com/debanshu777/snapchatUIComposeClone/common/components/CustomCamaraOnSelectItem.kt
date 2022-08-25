package com.debanshu777.snapchatUIComposeClone.common.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.debanshu777.snapchatUIComposeClone.R

/**
 * Custom camara on select item
 *
 * @param color
 * @param configuration
 * @param description
 */
@Composable
fun CustomCamaraOnSelectItem(
    color: Color,
    configuration: Configuration,
    description: String
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .width(60.dp)
            .height(30.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(MaterialTheme.colorScheme.surfaceTint)
    ) {
        AutoSizeIconWithPainter(
            modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
            size = 1.dp,
            tint = color,
            painter = painterResource(id = R.drawable.ic_camara),
            factor = 15f,
            badgeColor = color,
            configuration = configuration,
            contentDescription = description,
        )
    }
}
