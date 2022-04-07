package com.debanshu777.snapchatUIComposeClone.common.utils

import com.debanshu777.snapchatUIComposeClone.common.config.topBarConfig
import com.debanshu777.snapchatUIComposeClone.common.domain.model.TopBarItem

/**
 * Top bar formatter and route controller
 *
 * @param route
 * @return
 */
fun topBarFormatter(route: String?): TopBarItem {
    return when (route) {
        Screens.SnapMapScreen.route -> {
            topBarConfig(Screens.SnapMapScreen.route)
        }
        Screens.ChatScreen.route -> {
            topBarConfig(Screens.ChatScreen.route)
        }
        Screens.CamaraScreen.route -> {
            topBarConfig(Screens.CamaraScreen.route)
        }
        Screens.StoriesScreen.route -> {
            topBarConfig(Screens.StoriesScreen.route)
        }
        Screens.SpotlightScreen.route -> {
            topBarConfig(Screens.SpotlightScreen.route)
        }
        else -> {
            topBarConfig(Screens.CamaraScreen.route)
        }
    }
}
