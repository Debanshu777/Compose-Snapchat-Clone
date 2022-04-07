package com.debanshu777.snapchatUIComposeClone.features.feature_snap_map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.debanshu777.snapchatUIComposeClone.R
import com.debanshu777.snapchatUIComposeClone.common.utils.ThemeColors
import com.debanshu777.snapchatUIComposeClone.features.feature_snap_map.presentation.components.MapBottomNavigation
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings

@Composable
@Preview
fun SnapMapScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(
                    RoundedCornerShape(
                        bottomEnd = 10.dp,
                        bottomStart = 10.dp
                    )
                ),
        ) {
            val context = LocalContext.current
            GoogleMap(
                modifier = Modifier.fillMaxSize(),
                uiSettings = MapUiSettings(zoomControlsEnabled = false),
                properties = MapProperties(
                    mapStyleOptions = MapStyleOptions.loadRawResourceStyle(context, R.raw.style_json)
                ),
                cameraPositionState = CameraPositionState(
                    CameraPosition(
                        LatLng(22.5726, 88.3639), 12f, 0f, 0f
                    )
                )
            )
            Box(
                modifier = Modifier
                    .rotate(180f)
                    .fillMaxWidth()
                    .height(160.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                ThemeColors.MAP_DARK_GRADIENT
                            ),
                            startY = 10f
                        ),
                    )
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color(0x6F202020)
                            ),
                        ),
                    ),
                contentAlignment = Alignment.BottomCenter,
            ) {
                MapBottomNavigation()
            }
        }
    }
}
