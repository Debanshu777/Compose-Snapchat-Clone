package com.debanshu777.snapchatUIComposeClone.features.navigation.domain.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
    val onSelectedBatchVisible: Boolean,
    val onSelectedColor: Color,
    val onSelectIcon: ImageVector
)
