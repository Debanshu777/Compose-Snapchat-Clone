package com.debanshu777.snapchatUIComposeClone.features.feature_chat.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.debanshu777.snapchatUIComposeClone.common.config.ThemeColors
import com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain.ChatView
import com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain.ContentType

@Composable
fun ChatTypeItem(item:ChatView){
    if(!item.isChatOpened && !item.isLastContentSendToSender) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(color = giveColor(item))
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "New Snap",
            fontWeight = FontWeight.W400,
            color = giveColor(item)
        )
    }
    if(!item.isChatOpened && item.isLastContentSendToSender) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(color = giveColor(item))
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "New Snap",
            fontWeight = FontWeight.W400,
            color = giveColor(item)
        )
    }
    if(item.isChatOpened && !item.isLastContentSendToSender){
        if(item.lastContentType!= ContentType.chat) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .clip(RoundedCornerShape(3.dp))
                    .border(border = BorderStroke(2.dp, giveColor(item)))
            )
        }else{
            Icon(
                modifier= Modifier.size(14.dp),
                imageVector = Icons.Outlined.Send,
                contentDescription = "",
                tint= giveColor(item)
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "Opened",
            fontWeight = FontWeight.W400,
            color = ThemeColors.LIGHT_TINT_TEXT
        )
    }
    if(item.isChatOpened && item.isLastContentSendToSender){
        if(item.isChatUnseenBySender) {
            if(item.lastContentType != ContentType.chat) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .background(color = giveColor(item))
                )
            }else{
                Icon(
                    modifier= Modifier.size(14.dp),
                    imageVector = Icons.Default.Send,
                    contentDescription = "",
                    tint= giveColor(item)
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Delivered",
                fontWeight = FontWeight.W400,
                color = ThemeColors.LIGHT_TINT_TEXT
            )
        }else{
            if(item.lastContentType != ContentType.chat) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(RoundedCornerShape(3.dp))
                        .border(border = BorderStroke(2.dp, giveColor(item)))
                )
            }else{
                Icon(
                    modifier= Modifier.size(14.dp),
                    imageVector = Icons.Outlined.Send,
                    contentDescription = "",
                    tint= giveColor(item)
                )
            }
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Opened",
                fontWeight = FontWeight.W400,
                color = ThemeColors.LIGHT_TINT_TEXT
            )
        }

    }
}