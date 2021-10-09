package com.debanshu777.snapchatUIComposeClone.features.feature_camera

import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CamaraOpen(){
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    SimpleCameraPreview(
        modifier = Modifier.fillMaxSize(),
        context = context,
        lifecycleOwner = lifecycleOwner,
        onMediaCaptured = { url -> }
    )
}

@Composable
fun SimpleCameraPreview(
    modifier: Modifier = Modifier,
    context: Context,
    lifecycleOwner: LifecycleOwner,
    onMediaCaptured: (Uri?) -> Unit
) {
    val cameraProviderFuture = remember { ProcessCameraProvider.getInstance(context) }
    var imageCapture: ImageCapture? by remember { mutableStateOf(null) }
    var preview by remember { mutableStateOf<Preview?>(null) }
    val camera: Camera? = null
    var lensFacing by remember { mutableStateOf(CameraSelector.LENS_FACING_BACK) }
    var flashEnabled by remember { mutableStateOf(false) }
    var flashRes by remember { mutableStateOf(Icons.Default.FlashOff) }
    val executor = ContextCompat.getMainExecutor(context)
    var cameraSelector: CameraSelector?
    val cameraProvider = cameraProviderFuture.get()

    Box {
        AndroidView(
            modifier = modifier,
            factory = { ctx ->
                val previewView = PreviewView(ctx)
                cameraProviderFuture.addListener({
//                    val imageAnalysis = ImageAnalysis.Builder()
//                        .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
//                        .build()
//                        .apply {
//                            setAnalyzer(executor, FaceAnalyzer())
//                        }
                    imageCapture = ImageCapture.Builder()
                        .setTargetRotation(previewView.display.rotation)
                        .build()

                    val cameraSelector = CameraSelector.Builder()
                        .requireLensFacing(CameraSelector.LENS_FACING_BACK)
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
                .padding(bottom = 50.dp)
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
                Icon(
                    imageVector = Icons.Default.Filter,
                    contentDescription = "",
                    modifier = Modifier.size(30.dp),
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {
                    val imgCapture = imageCapture ?: return@Button
                },
                modifier = Modifier
                    .size(90.dp)
                    .background(Color.Transparent, CircleShape)
                    .shadow(4.dp, CircleShape)
                    .clip(CircleShape)
                    .border(5.dp, Color.White, CircleShape),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
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
                        cameraSelector as CameraSelector,
                        imageCapture,
                        preview
                    )
                }
            ) {
                Icon(
                    imageVector=Icons.Default.InsertEmoticon,
                    contentDescription = "",
                    modifier = Modifier.size(30.dp),
                    tint = Color.White
                )
            }
        }
    }
}

