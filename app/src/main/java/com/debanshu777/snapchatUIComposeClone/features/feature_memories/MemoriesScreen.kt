package com.debanshu777.snapchatUIComposeClone.features.feature_memories

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun MemoriesScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Memories screen")
    }
}