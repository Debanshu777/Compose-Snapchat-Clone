package com.debanshu777.snapchatUIComposeClone.common.utils

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.debanshu777.snapchatUIComposeClone.features.feature_camera.CamaraScreen
import com.debanshu777.snapchatUIComposeClone.features.feature_chat.ChatScreen
import com.debanshu777.snapchatUIComposeClone.features.feature_memories.MemoriesScreen
import com.debanshu777.snapchatUIComposeClone.features.feature_snap_map.SnapMapScreen
import com.debanshu777.snapchatUIComposeClone.features.feature_spotlight.SpotlightScreen
import com.debanshu777.snapchatUIComposeClone.features.feature_stories.StoriesScreen
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@ExperimentalAnimationApi
@ExperimentalPermissionsApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.CamaraScreen.route) {
        composable(Screens.SnapMapScreen.route) {
            SnapMapScreen()
        }
        composable(Screens.ChatScreen.route) {
            ChatScreen()
        }
        composable(Screens.CamaraScreen.route) {
            CamaraScreen()
        }
        composable(Screens.StoriesScreen.route) {
            StoriesScreen()
        }
        composable(Screens.SpotlightScreen.route) {
            SpotlightScreen()
        }
        composable(Screens.MemoriesScreen.route) {
            MemoriesScreen()
        }
    }
}
