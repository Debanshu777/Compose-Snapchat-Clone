package com.debanshu777.snapchatUIComposeClone.features.feature_camera

import android.Manifest
import androidx.camera.core.ExperimentalGetImage
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState

@ExperimentalPermissionsApi
@Composable
fun CamaraScreen() {
    Surface(
        modifier = Modifier
            .clip(RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp)),
    ) {
        val camaraPermissionState = rememberPermissionState(permission = Manifest.permission.CAMERA)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Spacer(modifier = Modifier.height(10.dp))
//            Button(onClick = {
//                camaraPermissionState.launchPermissionRequest()
//            }) {
//                Text(text = "Permissions")
//            }
//            Spacer(modifier = Modifier.height(20.dp))
            CamaraOpen()
        }
    }
}