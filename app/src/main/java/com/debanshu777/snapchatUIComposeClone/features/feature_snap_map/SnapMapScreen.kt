package com.debanshu777.snapchatUIComposeClone.features.feature_snap_map

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.debanshu777.snapchatUIComposeClone.R
import com.debanshu777.snapchatUIComposeClone.common.utils.ThemeColors
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.libraries.maps.CameraUpdateFactory
import com.google.android.libraries.maps.MapView
import com.google.android.libraries.maps.model.LatLng
import com.google.android.libraries.maps.model.MapStyleOptions
import com.google.maps.android.ktx.awaitMap
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


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
            val mapView = rememberMapViewWithLifecycle()
            val context = LocalContext.current
            AndroidView(
                {mapView}
            ){
                    mapView->
                CoroutineScope(Dispatchers.Main).launch {
                    val map= mapView.awaitMap()
                    map.uiSettings.isZoomControlsEnabled= false
                    map.setMapStyle(
                        MapStyleOptions.loadRawResourceStyle(
                            context, R.raw.style_json))
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(22.5,85.6),10f))
                }
            }
            Box(modifier = Modifier
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
            Box(modifier = Modifier
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
                )
            )
        }
    }

}

@Composable
fun rememberMapViewWithLifecycle(): MapView {
    val context = LocalContext.current
    val mapView= remember{
        MapView(context).apply {
            id=com.google.maps.android.ktx.R.id.map_frame
        }
    }
    val lifeCycleObserver = rememberMapLifecycleObserver(mapView)
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(lifecycle){
        lifecycle.addObserver(lifeCycleObserver)
        onDispose {
            lifecycle.removeObserver(lifeCycleObserver)
        }
    }
    return mapView
}

@Composable
fun rememberMapLifecycleObserver(mapView: MapView): LifecycleEventObserver =
    remember {
        LifecycleEventObserver{_,event ->
            when(event){
                Lifecycle.Event.ON_CREATE -> mapView.onCreate(Bundle())
                Lifecycle.Event.ON_START -> mapView.onStart()
                Lifecycle.Event.ON_RESUME -> mapView.onResume()
                Lifecycle.Event.ON_PAUSE -> mapView.onPause()
                Lifecycle.Event.ON_STOP -> mapView.onStop()
                Lifecycle.Event.ON_DESTROY-> mapView.onDestroy()
                else -> throw IllegalStateException()
            }

        }
    }

private  fun getDeviceLocation(context:Context):LatLng{
    val fusedLocationClient
    : FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)

    val deviceLocation = LatLng(0.0,0.0)
    try {

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // do proper permissions handling

        }else{
            val locationResult = fusedLocationClient.lastLocation

            locationResult
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val lastKnownLocation = task.result

                        if (lastKnownLocation != null) {
                           LatLng(
                               lastKnownLocation.latitude,
                               lastKnownLocation.longitude)
                        }
                    } else {
                        Log.d("Exception", " Current User location is null")
                    }
                }
                .addOnFailureListener {
                    Log.d("Hello", it.stackTraceToString())
                }
        }

    }catch (e: SecurityException){
        Log.d("Hello", "Exception:  $e.message.toString()")
    }
}
fun checkAndRequestPermissions(mContext:Context): Boolean {
    val internet = ContextCompat.checkSelfPermission(
        mContext,
        Manifest.permission.INTERNET
    )
    val loc = ContextCompat.checkSelfPermission(
        mContext,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )
    val loc2 = ContextCompat.checkSelfPermission(
        mContext,
        Manifest.permission.ACCESS_FINE_LOCATION
    )
    val listPermissionsNeeded: MutableList<String> = ArrayList()
    if (internet != PackageManager.PERMISSION_GRANTED) {
        listPermissionsNeeded.add(Manifest.permission.INTERNET)
    }
    if (loc != PackageManager.PERMISSION_GRANTED) {
        listPermissionsNeeded.add(Manifest.permission.ACCESS_COARSE_LOCATION)
    }
    if (loc2 != PackageManager.PERMISSION_GRANTED) {
        listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION)
    }
    if (listPermissionsNeeded.isNotEmpty()) {
        ActivityCompat.requestPermissions(
            (mContext as Activity?)!!,
            listPermissionsNeeded.toTypedArray(),
            1
        )
        return false
    }
    return true
}