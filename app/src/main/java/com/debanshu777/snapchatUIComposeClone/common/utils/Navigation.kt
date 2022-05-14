package com.debanshu777.snapchatUIComposeClone.common.utils

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffoldState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.debanshu777.snapchatUIComposeClone.features.feature_camera.CamaraScreen
import com.debanshu777.snapchatUIComposeClone.features.feature_chat.ChatScreen
import com.debanshu777.snapchatUIComposeClone.features.feature_memories.MemoriesScreen
import com.debanshu777.snapchatUIComposeClone.features.feature_snap_map.SnapMapScreen
import com.debanshu777.snapchatUIComposeClone.features.feature_spotlight.SpotlightScreen
import com.debanshu777.snapchatUIComposeClone.features.feature_stories.StoriesScreen
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import kotlinx.coroutines.CoroutineScope

/**
 * Navigation
 *
 * @param navController
 */
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@ExperimentalCoilApi
@ExperimentalAnimationApi
@ExperimentalPermissionsApi
@Composable
fun Navigation(navController: NavHostController,scope:CoroutineScope,bottomSheetScaffoldState: BottomSheetScaffoldState) {
    NavHost(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    bottomStart = 5.dp,
                    bottomEnd = 5.dp
                )
            )
            .padding(bottom = 55.dp)
            .background(color = Color.Black),
        navController = navController,
        startDestination = Screens.CamaraScreen.route
    ) {
        composable(Screens.SnapMapScreen.route) {
            FeaturesThatRequireLocationPermission(
                navigateToSettingsScreen = {},
                content = { SnapMapScreen() }
            )
        }
        composable(Screens.ChatScreen.route) {
            ChatScreen()
        }
        composable(Screens.CamaraScreen.route) {
            FeatureThatRequiresCameraPermission(
                navigateToSettingsScreen = {},
                content = { CamaraScreen(bottomSheetScaffoldState,scope) }
            )
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
