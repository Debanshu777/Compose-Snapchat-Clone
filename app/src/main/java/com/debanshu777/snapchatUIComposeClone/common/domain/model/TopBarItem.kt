package com.debanshu777.snapchatUIComposeClone.common.domain.model

import androidx.compose.ui.graphics.Color

data class TopBarItem(
    val name: String,
    val textColor: Color,
    val iconTint: Color,
    val backgroundTintForIcon: Color,
    val route: String
)