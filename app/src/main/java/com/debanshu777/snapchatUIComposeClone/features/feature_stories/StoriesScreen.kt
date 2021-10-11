package com.debanshu777.snapchatUIComposeClone.features.feature_stories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun StoriesScreen() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .clip(RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Stories screen")
    }
}