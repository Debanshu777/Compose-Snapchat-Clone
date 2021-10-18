package com.debanshu777.snapchatUIComposeClone.features.feature_spotlight

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
            .clip(RoundedCornerShape(bottomEnd = 10.dp, bottomStart =10.dp))
            .background(color = Color.Black))
    {
        LazyColumn(){
            items(spotlights.size) {index ->
                Box(
                    modifier=Modifier
                        .fillParentMaxSize()
                ) {
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