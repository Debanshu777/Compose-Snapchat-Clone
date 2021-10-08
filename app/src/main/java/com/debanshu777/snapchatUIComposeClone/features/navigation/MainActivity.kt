package com.debanshu777.snapchatUIComposeClone.features.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import com.debanshu777.snapchatUIComposeClone.features.navigation.components.CustomBottomNavigation
import com.debanshu777.snapchatUIComposeClone.features.navigation.utils.Navigation
import com.debanshu777.snapchatUIComposeClone.features.navigation.utils.navigationConfig
import com.debanshu777.snapchatUIComposeClone.ui.theme.ComposeSnapChatUITheme

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSnapChatUITheme{
                val navController = rememberNavController()
                Scaffold(
                        bottomBar = {
                            CustomBottomNavigation(
                                items = navigationConfig(),
                                navController = navController,
                                onItemClick ={
                                    navController.navigate(it.route)
                                }
                            )
                        }
                    ){
                    Navigation(navController = navController)
                }
                }
        }
    }
}