package com.debanshu777.snapchatUIComposeClone.features.feature_spotlight.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Footer user action
 *
 * @param modifier
 */
@Composable
fun FooterUserAction(modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        UserAction(
            icon = Icons.Outlined.Favorite,
        )
        Spacer(modifier = Modifier.height(10.dp))
        UserAction(
            icon = Icons.Default.Send,
        )
        Spacer(modifier = Modifier.height(10.dp))
        UserAction(
            icon = Icons.Default.MoreHoriz,
        )
    }
}
