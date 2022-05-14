package com.debanshu777.snapchatUIComposeClone.features.feature_camera

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.Surface
import androidx.compose.material.SwipeableState
import androidx.compose.material.rememberSwipeableState
import androidx.compose.material.swipeable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import com.debanshu777.snapchatUIComposeClone.features.feature_camera.presentation.components.SimpleCameraPreview
import com.debanshu777.snapchatUIComposeClone.features.feature_camera.state.SwipeableStates
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Camara screen
 *
 */
@SuppressLint("CoroutineCreationDuringComposition")
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@ExperimentalPermissionsApi
@Composable
fun CamaraScreen(state: BottomSheetScaffoldState,scope: CoroutineScope) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }
    Surface(
        modifier = Modifier
            .clip(RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp))
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    val (x,y) = dragAmount
                    when {
                        y > 0 -> {
                            scope.launch {
                                if(state.bottomSheetState.isExpanded){
                                    state.bottomSheetState.collapse()
                                }
                            }
                        }
                        y < 0 -> {
                            scope.launch {
                                if(state.bottomSheetState.isCollapsed){
                                    state.bottomSheetState.expand()
                                }
                            }
                        }
                    }

                    offsetX += dragAmount.x
                    offsetY += dragAmount.y
                }
            }
        ,
    ) {
       SimpleCameraPreview(
           modifier = Modifier
               .fillMaxSize(),
           context = context,
           lifecycleOwner = lifecycleOwner,
           onMediaCaptured = { url -> }
       )
    }
}
