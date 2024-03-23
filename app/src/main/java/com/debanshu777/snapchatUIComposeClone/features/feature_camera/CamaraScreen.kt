package com.debanshu777.snapchatUIComposeClone.features.feature_camera

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import com.debanshu777.snapchatUIComposeClone.features.feature_camera.presentation.components.SimpleCameraPreview
import com.google.accompanist.permissions.ExperimentalPermissionsApi

/**
 * Camara screen
 *
 */
@ExperimentalAnimationApi
@ExperimentalPermissionsApi
@Composable
fun CamaraScreen() {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp))
            .background(color = Color.White)
            .fillMaxSize(),
    ) {
        SimpleCameraPreview(
            modifier = Modifier.fillMaxSize(),
            context = context,
            lifecycleOwner = lifecycleOwner,
            onMediaCaptured = { url -> }
        )
    }
}
