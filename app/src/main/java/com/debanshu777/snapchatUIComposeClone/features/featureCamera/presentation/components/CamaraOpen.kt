package com.debanshu777.snapchatUIComposeClone.features.featureCamera.presentation.components

import android.content.res.Configuration
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FlashOff
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material.icons.filled.InsertEmoticon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.debanshu777.snapchatUIComposeClone.common.components.AutoSizeIcon
import com.debanshu777.snapchatUIComposeClone.common.utils.ThemeColors
import com.debanshu777.snapchatUIComposeClone.features.featureCamera.presentation.CameraUiState
import com.debanshu777.snapchatUIComposeClone.features.featureCamera.presentation.CameraViewModel
import com.debanshu777.snapchatUIComposeClone.features.featureCamera.presentation.CaptureResult

/**
 * Simplified camera preview using ViewModel for business logic
 *
 * @param modifier UI modifier
 * @param viewModel Camera ViewModel containing business logic
 * @param onCaptureResult Callback for capture results
 */
@Composable
fun SimpleCameraPreview(
    modifier: Modifier = Modifier,
    viewModel: CameraViewModel,
    onCaptureResult: (CaptureResult) -> Unit
) {
    val configuration = LocalConfiguration.current
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val cameraState = viewModel.cameraState

    Box(modifier = modifier) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { ctx ->
                PreviewView(ctx).apply {
                    scaleType = PreviewView.ScaleType.FILL_CENTER
                }
            },
            update = { previewView ->
                viewModel.getPreview()?.surfaceProvider = previewView.surfaceProvider
            }
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        ) {
            CameraControlsOverlay(
                cameraState = cameraState,
                configuration = configuration,
                onCaptureClick = {
                    viewModel.captureImage(context, onCaptureResult)
                },
                onFlipCamera = {
                    viewModel.flipCamera(lifecycleOwner)
                },
                onToggleFlash = {
                    viewModel.toggleFlash()
                }
            )
        }

        if (cameraState.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f)),
                contentAlignment = Alignment.Center
            ) {
                // You can add a CircularProgressIndicator here if needed
            }
        }
    }
}

@Composable
private fun CameraControlsOverlay(
    cameraState: CameraUiState,
    configuration: Configuration,
    onCaptureClick: () -> Unit,
    onFlipCamera: () -> Unit,
    onToggleFlash: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(Color.Transparent, RoundedCornerShape(15.dp))
            .padding(8.dp)
    ) {

        IconButton(onClick = onToggleFlash) {
            AutoSizeIcon(
                size = 1.dp,
                icon = if (cameraState.isFlashEnabled) Icons.Default.FlashOn else Icons.Default.FlashOff,
                factor = 15f,
                tint = ThemeColors.LIGHT_ICON_TINT,
                badgeColor = ThemeColors.RED,
                configuration = configuration,
                contentDescription = if (cameraState.isFlashEnabled) "Flash On" else "Flash Off",
                isBadge = true,
            )
        }
        
        Spacer(modifier = Modifier.width(20.dp))

        Button(
            onClick = onCaptureClick,
            modifier = Modifier
                .size(70.dp)
                .background(Color.Transparent, CircleShape)
                .shadow(4.dp, CircleShape)
                .clip(CircleShape)
                .border(5.dp, ThemeColors.LIGHT_ICON_TINT, CircleShape),
            colors = ButtonDefaults.buttonColors(Color.Transparent),
            enabled = !cameraState.isCapturing
        ) {
            // Empty button content - the styling makes it visible
        }
        
        Spacer(modifier = Modifier.width(20.dp))

        IconButton(onClick = onFlipCamera) {
            AutoSizeIcon(
                size = 1.dp,
                icon = Icons.Default.InsertEmoticon,
                factor = 15f,
                tint = ThemeColors.LIGHT_ICON_TINT,
                badgeColor = Color.White,
                configuration = configuration,
                contentDescription = "Flip Camera",
            )
        }
    }
}
