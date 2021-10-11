package com.debanshu777.snapchatUIComposeClone.features.feature_spotlight

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.debanshu777.snapchatUIComposeClone.features.feature_spotlight.data.datasource.DummySpotlightData
import com.debanshu777.snapchatUIComposeClone.features.feature_spotlight.presentation.components.SpotlightFooter
import com.debanshu777.snapchatUIComposeClone.features.feature_spotlight.presentation.components.VideoPlayer

val horizontalPadding = 10.dp
@Composable
fun SpotlightScreen() {
    val spotlights = DummySpotlightData.spotlight
    Box(
        Modifier
            .background(color = Color.Black)
            .padding(bottom = 40.dp)) {
        LazyColumn(flingBehavior = ScrollableDefaults.flingBehavior()){
            items(spotlights.size) {index ->
                Box(Modifier.fillParentMaxSize()) {
                    VideoPlayer(uri = spotlights[index].getVideoUrl())
                    Column(Modifier.align(Alignment.BottomStart)) {
                        SpotlightFooter(spotlights[index])
                        Divider()
                    }
                }
            }
        }
    }
}