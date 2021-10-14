package com.debanshu777.snapchatUIComposeClone.common.config

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.Group
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.PlayArrow
import com.debanshu777.snapchatUIComposeClone.common.domain.model.BottomNavItem
import com.debanshu777.snapchatUIComposeClone.common.utils.Screens

fun navigationConfig():List<BottomNavItem> {
    return listOf(
        BottomNavItem(
            name="Snap Map",
            route = Screens.SnapMapScreen.route,
            icon = Icons.Outlined.LocationOn,
            onSelectedBatchVisible = false,
            onSelectedColor = ThemeColors.GREEN,
            onSelectIcon =  Icons.Outlined.LocationOn,
        ),
        BottomNavItem(
            name="Chat",
            route = Screens.ChatScreen.route,
            icon = Icons.Default.ChatBubbleOutline,
            onSelectedBatchVisible = true,
            onSelectedColor = ThemeColors.BLUE,
            onSelectIcon = Icons.Default.ChatBubbleOutline,
        ),
        BottomNavItem(
            name="Camara",
            route = Screens.CamaraScreen.route,
            icon = Icons.Outlined.CameraAlt,
            onSelectedBatchVisible = false,
            onSelectedColor = ThemeColors.YELLOW,
            onSelectIcon =  Icons.Default.CameraAlt,
        ),
        BottomNavItem(
            name="Stories",
            route = Screens.StoriesScreen.route,
            icon = Icons.Outlined.Group,
            onSelectedBatchVisible = true,
            onSelectedColor = ThemeColors.PURPLE,
            onSelectIcon =  Icons.Outlined.Group,
        ),
        BottomNavItem(
            name="Spotlight",
            route = Screens.SpotlightScreen.route,
            icon = Icons.Outlined.PlayArrow,
            onSelectedBatchVisible = false,
            onSelectedColor = ThemeColors.RED,
            onSelectIcon =  Icons.Outlined.PlayArrow,
        )
    )
}