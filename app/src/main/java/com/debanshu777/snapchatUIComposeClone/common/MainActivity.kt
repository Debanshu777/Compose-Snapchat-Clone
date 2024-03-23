package com.debanshu777.snapchatUIComposeClone.common

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.debanshu777.snapchatUIComposeClone.R
import com.debanshu777.snapchatUIComposeClone.common.components.CustomBottomNavigation
import com.debanshu777.snapchatUIComposeClone.common.components.CustomTopBar
import com.debanshu777.snapchatUIComposeClone.common.config.navigationConfig
import com.debanshu777.snapchatUIComposeClone.common.utils.Navigation
import com.debanshu777.snapchatUIComposeClone.common.utils.topBarFormatter
import com.debanshu777.snapchatUIComposeClone.ui.theme.ComposeSnapChatUITheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(
        ExperimentalFoundationApi::class,
        ExperimentalCoilApi::class,
        ExperimentalAnimationApi::class,
        ExperimentalPermissionsApi::class,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_ComposeCameraX)
        setContent {
            ComposeSnapChatUITheme {
                val navController = rememberNavController()
                val backStack = navController.currentBackStackEntryAsState()
                Scaffold(
                    containerColor = Color.Black,
                    topBar = {
                        Box {
                            Navigation(navController = navController)
                            CustomTopBar(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                topBarItem = topBarFormatter(backStack.value?.destination?.route)
                            )
                        }
                    },
                    bottomBar = {
                        CustomBottomNavigation(
                            items = navigationConfig(),
                            navController = navController,
                            onItemClick = {
                                navController.navigate(it.route)
                            }
                        )
                    },
                ) {}
            }
        }
    }
}
