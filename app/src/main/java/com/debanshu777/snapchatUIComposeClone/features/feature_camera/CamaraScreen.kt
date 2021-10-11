package com.debanshu777.snapchatUIComposeClone.features.feature_camera

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.rememberPermissionState
import android.Manifest
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import com.debanshu777.snapchatUIComposeClone.common.utils.FeatureThatRequiresCameraPermission
import com.debanshu777.snapchatUIComposeClone.features.feature_camera.presentation.components.SimpleCameraPreview
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@ExperimentalAnimationApi
@ExperimentalPermissionsApi
@Composable
fun CamaraScreen() {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    Surface(
        modifier = Modifier
            .clip(RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp)),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
                FeatureThatRequiresCameraPermission (
                    navigateToSettingsScreen = {}
                )
                SimpleCameraPreview(
                    modifier = Modifier.fillMaxSize(),
                    context = context,
                    lifecycleOwner = lifecycleOwner,
                    onMediaCaptured = { url -> }
                )
            }
        }
    }