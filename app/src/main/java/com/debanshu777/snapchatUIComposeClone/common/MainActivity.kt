package com.debanshu777.snapchatUIComposeClone.common

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.navigation.compose.rememberNavController
import com.debanshu777.snapchatUIComposeClone.common.components.CustomBottomNavigation
import com.debanshu777.snapchatUIComposeClone.common.components.CustomTopBar
import com.debanshu777.snapchatUIComposeClone.common.utils.Navigation
import com.debanshu777.snapchatUIComposeClone.common.config.navigationConfig
import com.debanshu777.snapchatUIComposeClone.ui.theme.ComposeSnapChatUITheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.android.material.shape.Shapeable
import java.util.*

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    @ExperimentalPermissionsApi
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSnapChatUITheme{
                val navController = rememberNavController()
                Scaffold(
                        topBar= {
                            Box(){
                                Navigation(navController = navController)
                                CustomTopBar()
                            }

                        },
                        bottomBar = {
                            CustomBottomNavigation(
                                items = navigationConfig(),
                                navController = navController,
                                modifier =Modifier,
                                onItemClick ={
                                    navController.navigate(it.route)
                                }
                            )
                        },
                    ){}
                }
        }
    }
}