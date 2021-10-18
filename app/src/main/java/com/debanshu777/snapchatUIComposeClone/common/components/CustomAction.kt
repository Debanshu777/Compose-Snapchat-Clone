package com.debanshu777.snapchatUIComposeClone.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cameraswitch
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.PersonAdd
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.debanshu777.snapchatUIComposeClone.common.domain.model.TopBarItem

@Composable
fun CustomAction(topBarItem:TopBarItem){
    if(topBarItem.lastAction=="Setting"){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(topBarItem.backgroundTintForIcon)
        ) {
            Icon(
                modifier = Modifier.size(25.dp),
                imageVector = Icons.Default.Settings,
                contentDescription = "Setting",
                tint = topBarItem.iconTint
            )
        }
    }else{
        Row {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(topBarItem.backgroundTintForIcon)
            ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = Icons.Default.PersonAdd,
                    contentDescription = "Search",
                    tint = topBarItem.iconTint
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
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector =
                    if(topBarItem.lastAction == "More Action")
                        Icons.Default.MoreHoriz
                    else
                        Icons.Default.Cameraswitch
                    ,
                    contentDescription = "Search",
                    tint = topBarItem.iconTint
                )
            }
        }
    }
}