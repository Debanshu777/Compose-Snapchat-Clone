package com.debanshu777.snapchatUIComposeClone.common.utils

import android.Manifest
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionRequired
import com.google.accompanist.permissions.rememberPermissionState

@ExperimentalPermissionsApi
@Composable
fun FeaturesThatRequireLocationPermission(
    navigateToSettingsScreen: () -> Unit,
    content: @Composable ()->Unit
){
    var doNotShowRationale by rememberSaveable { mutableStateOf(false) }
    val locationPermissionState = rememberPermissionState(Manifest.permission.ACCESS_COARSE_LOCATION)
    PermissionRequired(
        permissionState = locationPermissionState,
        permissionNotGrantedContent = {
            if (doNotShowRationale) {
                Text("Feature not available")
            } else {
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text="The location is important for this app. Please grant the permission."
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Button(onClick = {
                            locationPermissionState.launchPermissionRequest()
                        }) {
                            Text("Allow")
                        }
                        Spacer(Modifier.width(8.dp))
                        Button(onClick = { doNotShowRationale = true }) {
                            Text("Deny")
                        }
                    }
                }
            }
        },
        permissionNotAvailableContent = {
            Column(
                modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text ="Location permission denied. See this FAQ with information about why we " +
                            "need this permission. Please, grant us access on the Settings screen."
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = navigateToSettingsScreen) {
                    Text("Open Settings")
                }
            }
        },
        content = content

    )
}