package com.debanshu777.snapchatUIComposeClone.features.feature_spotlight.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun UserAction(
    icon: ImageVector,
) {
    Icon(
        imageVector = icon,
        tint = Color.White,
        modifier = Modifier
            .clip(CircleShape)
            .background(color = Color.DarkGray)
            .padding(10.dp)
            .size(28.dp),
        contentDescription = null
    )
}