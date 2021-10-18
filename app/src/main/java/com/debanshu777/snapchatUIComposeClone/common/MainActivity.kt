package com.debanshu777.snapchatUIComposeClone.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.debanshu777.snapchatUIComposeClone.R
import com.debanshu777.snapchatUIComposeClone.common.components.CustomBottomNavigation
import com.debanshu777.snapchatUIComposeClone.common.components.CustomTopBar
import com.debanshu777.snapchatUIComposeClone.common.utils.Navigation
import com.debanshu777.snapchatUIComposeClone.common.config.navigationConfig
import com.debanshu777.snapchatUIComposeClone.common.utils.TopBarFormatter
import com.debanshu777.snapchatUIComposeClone.ui.theme.ComposeSnapChatUITheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    @ExperimentalCoilApi
    @ExperimentalAnimationApi
    @ExperimentalPermissionsApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_ComposeCameraX)
        setContent {
            ComposeSnapChatUITheme{
                val navController = rememberNavController()
                val backStack = navController.currentBackStackEntryAsState()
                Scaffold(
                        topBar= {
                            Box(){
                                Navigation(navController = navController)
                                CustomTopBar(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    topBarItem = TopBarFormatter(backStack.value?.destination?.route)
                                )
                            }

                        },
                        bottomBar = {
                            CustomBottomNavigation(
                                items = navigationConfig(),
                                navController = navController,
                                modifier = Modifier,
                                onItemClick = {
                                    navController.navigate(it.route)
                                }
                            )
                        },
                    ){}
                }
        }
    }
}