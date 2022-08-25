package com.debanshu777.snapchatUIComposeClone.common.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cameraswitch
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.debanshu777.snapchatUIComposeClone.common.domain.model.TopBarItem

/**
 * Custom action bar
 *
 * @param topBarItem
 * @param configuration
 */
@Composable
fun CustomActionBar(topBarItem: TopBarItem, configuration: Configuration) {
    if (topBarItem.lastAction == "Setting") {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(topBarItem.backgroundTintForIcon)
        ) {
            AutoSizeIcon(
                size = 1.dp,
                icon = Icons.Default.Settings,
                factor = 17f,
                tint = topBarItem.iconTint,
                badgeColor = Color.White,
                configuration = configuration,
                contentDescription = "Setting",
            )
        }
    } else {
        Row {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(topBarItem.backgroundTintForIcon)
            ) {
                AutoSizeIcon(
                    size = 1.dp,
                    icon = Icons.Default.PersonAdd,
                    factor = 17f,
                    tint = topBarItem.iconTint,
                    badgeColor = Color.White,
                    configuration = configuration,
                    contentDescription = "Add Person",
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(topBarItem.backgroundTintForIcon)
            ) {
                AutoSizeIcon(
                    size = 1.dp,
                    icon =
                    if (topBarItem.lastAction == "More Action")
                        Icons.Default.MoreHoriz
                    else
                        Icons.Default.Cameraswitch,
                    factor = 17f,
                    tint = topBarItem.iconTint,
                    badgeColor = Color.White,
                    configuration = configuration,
                    contentDescription = "More Actions",
                )
            }
        }
    }
}
