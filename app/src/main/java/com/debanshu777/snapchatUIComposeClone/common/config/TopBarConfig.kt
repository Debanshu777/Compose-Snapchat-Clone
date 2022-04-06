package com.debanshu777.snapchatUIComposeClone.common.config

import androidx.compose.ui.graphics.Color
import com.debanshu777.snapchatUIComposeClone.common.domain.model.TopBarItem
import com.debanshu777.snapchatUIComposeClone.common.utils.Messages
import com.debanshu777.snapchatUIComposeClone.common.utils.Screens
import com.debanshu777.snapchatUIComposeClone.common.utils.ThemeColors

/**
 * Top bar config
 *
 * @param route
 * @return
 */
fun topBarConfig(route: String): TopBarItem {
    val listOfTopBarConfig = listOf(
        TopBarItem(
            name = Messages.SNAP_HEADING,
            textColor = ThemeColors.LIGHT_ICON_TINT,
            backgroundTintForIcon = ThemeColors.DARK_TRANSPARENT,
            iconTint = ThemeColors.LIGHT_ICON_TINT,
            route = Screens.SnapMapScreen.route,
            isBackgroundTransparent = true,
            isAvailable = true,
            lastAction = "Setting"
        ),
        TopBarItem(
            name = Messages.CHAT_HEADING,
            textColor = Color.Black,
            backgroundTintForIcon = ThemeColors.LIGHT_TRANSPARENT,
            iconTint = ThemeColors.DARK_ICON_TINT,
            route = Screens.ChatScreen.route,
            isAvailable = true,
            lastAction = "More Action"
        ),
        TopBarItem(
            name = "",
            textColor = ThemeColors.LIGHT_ICON_TINT,
            backgroundTintForIcon = ThemeColors.DARK_TRANSPARENT,
            iconTint = ThemeColors.LIGHT_ICON_TINT,
            route = Screens.CamaraScreen.route,
            isBackgroundTransparent = true,
            isAvailable = true,
            lastAction = "Camara Rotate"
        ),
        TopBarItem(
            name = Messages.STORIES_HEADING,
            textColor = Color.Black,
            backgroundTintForIcon = ThemeColors.LIGHT_TRANSPARENT,
            iconTint = ThemeColors.DARK_ICON_TINT,
            route = Screens.StoriesScreen.route,
            isAvailable = true,
            lastAction = "More Action"
        ),
        TopBarItem(
            name = Messages.SPOTLIGHT_HEADING,
            textColor = ThemeColors.LIGHT_ICON_TINT,
            backgroundTintForIcon = ThemeColors.DARK_TRANSPARENT,
            iconTint = ThemeColors.LIGHT_ICON_TINT,
            route = Screens.SpotlightScreen.route,
            isBackgroundTransparent = true,
            isAvailable = false,
            lastAction = "None"
        )
    )
    return listOfTopBarConfig.find { it.route == route }!!
}
