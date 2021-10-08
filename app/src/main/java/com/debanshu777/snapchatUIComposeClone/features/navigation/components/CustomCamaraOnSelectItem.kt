package com.debanshu777.snapchatUIComposeClone.features.navigation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CustomCamaraOnSelectItem(iconImage: ImageVector, color: Color){
    Box(
        contentAlignment= Alignment.Center,
        modifier = Modifier
            .width(60.dp)
            .height(30.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(Color.DarkGray)) {
        Icon(
            tint= color,
            modifier = Modifier.size(30.dp),
            imageVector = iconImage,
            contentDescription = "Custom View",
        )
    }
}