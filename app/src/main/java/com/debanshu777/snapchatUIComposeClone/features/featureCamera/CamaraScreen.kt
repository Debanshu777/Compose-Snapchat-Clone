package com.debanshu777.snapchatUIComposeClone.features.featureCamera

import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.debanshu777.snapchatUIComposeClone.common.utils.FeatureThatRequiresCameraPermission
import com.debanshu777.snapchatUIComposeClone.features.featureCamera.presentation.CameraViewModel
import com.debanshu777.snapchatUIComposeClone.features.featureCamera.presentation.CaptureResult
import com.debanshu777.snapchatUIComposeClone.features.featureCamera.presentation.components.SimpleCameraPreview
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@ExperimentalAnimationApi
@ExperimentalPermissionsApi
@Composable
fun CamaraScreen(
    viewModel: CameraViewModel = viewModel()
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(context, lifecycleOwner) {
        viewModel.initializeCamera(context, lifecycleOwner)
    }

    FeatureThatRequiresCameraPermission(
        navigateToSettingsScreen = {
            Log.d("CameraScreen", "Navigate to settings for camera permission")
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp)
                .clip(RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp)),
        ) {
            Box {
                SimpleCameraPreview(
                    modifier = Modifier.fillMaxSize(),
                    viewModel = viewModel,
                    onCaptureResult = { result ->
                        when (result) {
                            is CaptureResult.Success -> {
                                Log.d("CameraScreen", "Media captured: ${result.uri}")
                            }
                            is CaptureResult.Error -> {
                                Log.e("CameraScreen", "Capture failed: ${result.message}")
                            }
                        }
                    }
                )
            }
        }
    }
}
