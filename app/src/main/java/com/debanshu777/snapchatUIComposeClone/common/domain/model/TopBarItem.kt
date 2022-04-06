package com.debanshu777.snapchatUIComposeClone.common.domain.model

import androidx.compose.ui.graphics.Color

/**
 * Top bar item data class
 *
 * @property name
 * @property textColor
 * @property iconTint
 * @property backgroundTintForIcon
 * @property route
 * @property isBackgroundTransparent
 * @property isAvailable
 * @property lastAction
 * @constructor Create empty Top bar item
 */
data class TopBarItem(
    val name: String,
    val textColor: Color,
    val iconTint: Color,
    val backgroundTintForIcon: Color,
    val route: String,
    val isBackgroundTransparent: Boolean = false,
    val isAvailable: Boolean,
    val lastAction: String = "None"
)
