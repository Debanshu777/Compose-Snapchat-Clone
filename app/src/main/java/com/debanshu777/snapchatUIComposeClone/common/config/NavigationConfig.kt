package com.debanshu777.snapchatUIComposeClone.common.config

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.outlined.Group
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.ui.graphics.Color
import com.debanshu777.snapchatUIComposeClone.common.domain.model.BottomNavItem
import com.debanshu777.snapchatUIComposeClone.common.utils.Screens

fun navigationConfig():List<BottomNavItem> {
    return listOf(
        BottomNavItem(
            name="Snap Map",
            route = Screens.SnapMapScreen.route,
            icon = Icons.Outlined.LocationOn,
            onSelectedBatchVisible = false,
            onSelectedColor = Color(0xCD47EEAB),
            onSelectIcon =  Icons.Outlined.LocationOn,
        ),
        BottomNavItem(
            name="Chat",
            route = Screens.ChatScreen.route,
            icon = Icons.Default.ChatBubbleOutline,
            onSelectedBatchVisible = false,
            onSelectedColor = Color(0xFF00CCFF),
            onSelectIcon = Icons.Default.ChatBubbleOutline,
        ),
        BottomNavItem(
            name="Camara",
            route = Screens.CamaraScreen.route,
            icon = Icons.Default.CameraAlt,
            onSelectedBatchVisible = false,
            onSelectedColor = Color(0xFFFFFC00),
            onSelectIcon =  Icons.Default.CameraAlt,
        ),
        BottomNavItem(
            name="Stories",
            route = Screens.StoriesScreen.route,
            icon = Icons.Outlined.Group,
            onSelectedBatchVisible = false,
            onSelectedColor = Color(0xC19D00FF),
            onSelectIcon =  Icons.Outlined.Group,
        ),
        BottomNavItem(
            name="Spotlight",
            route = Screens.SpotlightScreen.route,
            icon = Icons.Outlined.PlayArrow,
            onSelectedBatchVisible = false,
            onSelectedColor = Color(0xCDFF0051),
            onSelectIcon =  Icons.Outlined.PlayArrow,
        )
    )
}