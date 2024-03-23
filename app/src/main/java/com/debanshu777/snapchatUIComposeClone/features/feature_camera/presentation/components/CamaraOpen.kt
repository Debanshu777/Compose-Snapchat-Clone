package com.debanshu777.snapchatUIComposeClone.features.feature_camera.presentation.components

import android.content.Context
import android.net.Uri
import androidx.camera.core.Camera
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Filter
import androidx.compose.material.icons.filled.FlashOff
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material.icons.filled.InsertEmoticon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.debanshu777.snapchatUIComposeClone.common.components.AutoSizeIcon
import com.debanshu777.snapchatUIComposeClone.common.utils.ThemeColors

/**
 * Simple camera preview
 *
 * @param modifier
 * @param context
 * @param lifecycleOwner
 * @param onMediaCaptured
 * @receiver
 */
@Composable
fun SimpleCameraPreview(
    modifier: Modifier = Modifier,
    context: Context,
    lifecycleOwner: LifecycleOwner,
    onMediaCaptured: (Uri?) -> Unit
) {
    val configuration = LocalConfiguration.current
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    var imageCapture: ImageCapture? by remember { mutableStateOf(null) }
    var preview by remember { mutableStateOf<Preview?>(null) }
    val camera: Camera? = null
    var lensFacing by remember { mutableIntStateOf(CameraSelector.LENS_FACING_BACK) }
    var flashEnabled by remember { mutableStateOf(false) }
    var flashRes by remember { mutableStateOf(Icons.Default.FlashOff) }
    val executor = ContextCompat.getMainExecutor(context)
    var cameraSelector: CameraSelector = CameraSelector.Builder()
        .requireLensFacing(CameraSelector.LENS_FACING_BACK)
        .build()
    val cameraProvider = cameraProviderFuture.get()

    Box {
        AndroidView(
            modifier = modifier,
            factory = { ctx ->
                val previewView = PreviewView(ctx)
                cameraProviderFuture.addListener({
                    imageCapture = ImageCapture.Builder()
                        .setTargetRotation(previewView.display.rotation)
                        .build()

                    cameraProvider.unbindAll()
                    cameraProvider.bindToLifecycle(
                        lifecycleOwner,
                        cameraSelector,
                        imageCapture,
                        preview
                    )
                }, executor)
                preview = Preview.Builder().build().also {
                    it.setSurfaceProvider(previewView.surfaceProvider)
                }
                previewView
            }
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.Transparent, RoundedCornerShape(15.dp))
                .padding(8.dp)
                .align(Alignment.BottomCenter)
        ) {
            IconButton(
                onClick = {
                    camera?.let {
                        if (it.cameraInfo.hasFlashUnit()) {
                            flashEnabled = !flashEnabled
                            flashRes = if (flashEnabled) Icons.Default.FlashOff else
                                Icons.Default.FlashOn
                            it.cameraControl.enableTorch(flashEnabled)
                        }
                    }
                }
            ) {
                AutoSizeIcon(
                    size = 1.dp,
                    icon = Icons.Default.Filter,
                    factor = 15f,
                    tint = ThemeColors.LIGHT_ICON_TINT,
                    badgeColor = ThemeColors.RED,
                    configuration = configuration,
                    contentDescription = "Memories",
                    isBadge = true,
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {
                    imageCapture ?: return@Button
                },
                modifier = Modifier
                    .size(90.dp)
                    .background(Color.Transparent, CircleShape)
                    .shadow(4.dp, CircleShape)
                    .clip(CircleShape)
                    .border(5.dp, ThemeColors.LIGHT_ICON_TINT, CircleShape),
                colors = ButtonDefaults.buttonColors(Color.Transparent),
            ) {
            }
            Spacer(modifier = Modifier.width(20.dp))
            IconButton(
                onClick = {
                    lensFacing = if (lensFacing == CameraSelector.LENS_FACING_BACK) CameraSelector.LENS_FACING_FRONT
                    else CameraSelector.LENS_FACING_BACK

                    cameraSelector = CameraSelector.Builder()
                        .requireLensFacing(lensFacing)
                        .build()
                    cameraProvider.unbindAll()
                    cameraProvider.bindToLifecycle(
                        lifecycleOwner,
                        cameraSelector,
                        imageCapture,
                        preview
                    )
                }
            ) {
                AutoSizeIcon(
                    size = 1.dp,
                    icon = Icons.Default.InsertEmoticon,
                    factor = 15f,
                    tint = ThemeColors.LIGHT_ICON_TINT,
                    badgeColor = Color.White,
                    configuration = configuration,
                    contentDescription = "Filters",
                )
            }
        }
    }
}
