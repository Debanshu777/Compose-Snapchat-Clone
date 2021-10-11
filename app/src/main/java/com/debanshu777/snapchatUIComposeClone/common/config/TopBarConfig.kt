package com.debanshu777.snapchatUIComposeClone.common.config

import androidx.compose.ui.graphics.Color
import com.debanshu777.snapchatUIComposeClone.common.domain.model.TopBarItem
import com.debanshu777.snapchatUIComposeClone.common.utils.Screens

fun topBarConfig(route:String): TopBarItem {
    val listOfTopBarConfig= listOf(
        TopBarItem(
            name = "Snap Map",
            textColor = Color.White,
            backgroundTintForIcon = Color.DarkGray,
            iconTint = Color.White,
            route = Screens.SnapMapScreen.route
        ),
        TopBarItem(
            name = "Chat",
            textColor = Color.Black,
            backgroundTintForIcon = Color(0xFF999898),
            iconTint = Color.DarkGray,
            route = Screens.ChatScreen.route
        ),
        TopBarItem(
            name = "",
            textColor = Color.White,
            backgroundTintForIcon = Color.DarkGray,
            iconTint = Color.White,
            route = Screens.CamaraScreen.route
        ),
        TopBarItem(
            name = "Stories",
            textColor = Color.Black,
            backgroundTintForIcon = Color(0xFF999898),
            iconTint = Color.DarkGray,
            route = Screens.StoriesScreen.route
        ),
        TopBarItem(
            name = "Spotlight",
            textColor = Color.White,
            backgroundTintForIcon = Color.DarkGray,
            iconTint = Color.White,
            route = Screens.SpotlightScreen.route
        )
    )
    return listOfTopBarConfig.find { it.route == route }!!
}