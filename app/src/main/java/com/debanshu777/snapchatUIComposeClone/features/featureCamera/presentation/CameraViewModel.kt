package com.debanshu777.snapchatUIComposeClone.features.featureCamera.presentation

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.camera.core.Camera
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class CameraViewModel : ViewModel() {

    var cameraState by mutableStateOf(CameraUiState())
        private set

    private var camera: Camera? = null
    private var imageCapture: ImageCapture? = null
    private var preview: Preview? = null
    private var cameraProvider: ProcessCameraProvider? = null

    fun initializeCamera(context: Context, lifecycleOwner: LifecycleOwner) {
        viewModelScope.launch {
            try {
                cameraState = cameraState.copy(isLoading = true, error = null)
                
                withContext(Dispatchers.Main) {
                    val cameraProviderFuture = ProcessCameraProvider.getInstance(context)
                    cameraProvider = cameraProviderFuture.get()
                    
                    setupCamera(lifecycleOwner)
                    
                    cameraState = cameraState.copy(
                        isLoading = false,
                        isInitialized = true
                    )
                }
            } catch (e: Exception) {
                Log.e(TAG, "Camera initialization failed", e)
                cameraState = cameraState.copy(
                    isLoading = false,
                    error = "Failed to initialize camera: ${e.message}"
                )
            }
        }
    }

    private fun setupCamera(lifecycleOwner: LifecycleOwner) {
        imageCapture = ImageCapture.Builder()
            .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
            .build()
        
        preview = Preview.Builder().build()
        
        bindCameraToLifecycle(lifecycleOwner)
    }

    private fun bindCameraToLifecycle(lifecycleOwner: LifecycleOwner) {
        cameraProvider?.let { provider ->
            try {
                provider.unbindAll()
                
                val cameraSelector = CameraSelector.Builder()
                    .requireLensFacing(cameraState.lensFacing)
                    .build()
                
                camera = provider.bindToLifecycle(
                    lifecycleOwner,
                    cameraSelector,
                    imageCapture,
                    preview
                )
                
                // Update flash availability
                val hasFlash = camera?.cameraInfo?.hasFlashUnit() == true
                cameraState = cameraState.copy(hasFlashUnit = hasFlash)
                
            } catch (e: Exception) {
                Log.e(TAG, "Camera binding failed", e)
                cameraState = cameraState.copy(
                    error = "Failed to bind camera: ${e.message}"
                )
            }
        }
    }

    fun captureImage(context: Context, onResult: (CaptureResult) -> Unit) {
        val imageCapture = this.imageCapture
        if (imageCapture == null) {
            onResult(CaptureResult.Error("Camera not initialized"))
            return
        }
        
        if (cameraState.isCapturing) {
            Log.w(TAG, "Capture already in progress")
            return
        }
        
        cameraState = cameraState.copy(isCapturing = true)
        
        viewModelScope.launch {
            try {
                val photoFile = createImageFile(context)
                val outputFileOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()
                
                withContext(Dispatchers.Main) {
                    imageCapture.takePicture(
                        outputFileOptions,
                        ContextCompat.getMainExecutor(context),
                        object : ImageCapture.OnImageSavedCallback {
                            override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                                val uri = Uri.fromFile(photoFile)
                                cameraState = cameraState.copy(
                                    isCapturing = false,
                                    lastCapturedImageUri = uri
                                )
                                onResult(CaptureResult.Success(uri))
                                Log.d(TAG, "Image captured successfully: $uri")
                            }
                            
                            override fun onError(exception: ImageCaptureException) {
                                cameraState = cameraState.copy(isCapturing = false)
                                val message = "Image capture failed: ${exception.message}"
                                Log.e(TAG, message, exception)
                                onResult(CaptureResult.Error(message))
                            }
                        }
                    )
                }
            } catch (e: Exception) {
                cameraState = cameraState.copy(isCapturing = false)
                val message = "Failed to initiate capture: ${e.message}"
                Log.e(TAG, message, e)
                onResult(CaptureResult.Error(message))
            }
        }
    }

    fun flipCamera(lifecycleOwner: LifecycleOwner) {
        if (cameraState.isLoading) {
            Log.w(TAG, "Camera is still loading, cannot flip")
            return
        }
        
        viewModelScope.launch {
            try {
                val newLensFacing = if (cameraState.lensFacing == CameraSelector.LENS_FACING_BACK) {
                    CameraSelector.LENS_FACING_FRONT
                } else {
                    CameraSelector.LENS_FACING_BACK
                }
                
                cameraState = cameraState.copy(lensFacing = newLensFacing)
                
                withContext(Dispatchers.Main) {
                    bindCameraToLifecycle(lifecycleOwner)
                }
                
                Log.d(TAG, "Camera flipped to ${if (newLensFacing == CameraSelector.LENS_FACING_FRONT) "front" else "back"}")
            } catch (e: Exception) {
                Log.e(TAG, "Failed to flip camera", e)
                cameraState = cameraState.copy(
                    error = "Failed to flip camera: ${e.message}"
                )
            }
        }
    }

    fun toggleFlash() {
        val camera = this.camera
        if (camera == null) {
            Log.w(TAG, "Camera not available for flash toggle")
            return
        }
        
        if (!camera.cameraInfo.hasFlashUnit()) {
            Log.w(TAG, "Flash unit not available")
            return
        }
        
        try {
            val newFlashState = !cameraState.isFlashEnabled
            camera.cameraControl.enableTorch(newFlashState)
            cameraState = cameraState.copy(isFlashEnabled = newFlashState)
            Log.d(TAG, "Flash ${if (newFlashState) "enabled" else "disabled"}")
        } catch (e: Exception) {
            Log.e(TAG, "Failed to toggle flash", e)
            cameraState = cameraState.copy(
                error = "Failed to toggle flash: ${e.message}"
            )
        }
    }

    fun getPreview(): Preview? = preview

    fun clearError() {
        cameraState = cameraState.copy(error = null)
    }

    private fun createImageFile(context: Context): File {
        val timestamp = SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS", Locale.US).format(Date())
        return File(context.cacheDir, "IMG_${timestamp}.jpg")
    }

    override fun onCleared() {
        super.onCleared()
        try {
            cameraProvider?.unbindAll()
            camera = null
            imageCapture = null
            preview = null
            cameraProvider = null
            Log.d(TAG, "Camera resources cleaned up")
        } catch (e: Exception) {
            Log.e(TAG, "Error during camera cleanup", e)
        }
    }
    
    companion object {
        private const val TAG = "CameraViewModel"
    }
}

data class CameraUiState(
    val isLoading: Boolean = false,
    val isInitialized: Boolean = false,
    val isCapturing: Boolean = false,
    val isFlashEnabled: Boolean = false,
    val hasFlashUnit: Boolean = false,
    val lensFacing: Int = CameraSelector.LENS_FACING_BACK,
    val lastCapturedImageUri: Uri? = null,
    val error: String? = null
)

sealed class CaptureResult {
    data class Success(val uri: Uri) : CaptureResult()
    data class Error(val message: String) : CaptureResult()
}
