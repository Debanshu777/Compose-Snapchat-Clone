package com.debanshu777.snapchatUIComposeClone.features.feature_chat.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.debanshu777.snapchatUIComposeClone.common.components.AutoSizeText
import com.debanshu777.snapchatUIComposeClone.common.utils.ThemeColors
import com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain.ChatView
import com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain.ContentType

/**
 * Chat type item
 *
 * @param item
 * @param configuration
 */
@Composable
fun ChatTypeItem(item:ChatView,configuration: Configuration){
    if(!item.isChatOpened && !item.isLastContentSendToSender) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(color = giveColor(item))
        )
        Spacer(modifier = Modifier.width(5.dp))
        AutoSizeText(
            factor=0.85f,
            text = "New Snap",
            textColor = giveColor(item),
            fontWeight=FontWeight.W400,
            textStyle = TextStyle(fontSize = 14.sp),
            configuration = configuration)
    }
    if(!item.isChatOpened && item.isLastContentSendToSender) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .clip(RoundedCornerShape(3.dp))
                .background(color = giveColor(item))
        )
        Spacer(modifier = Modifier.width(5.dp))
        AutoSizeText(
            factor=0.85f,
            text = "New Snap",
            textColor = giveColor(item),
            fontWeight=FontWeight.W400,
            textStyle = TextStyle(fontSize = 14.sp),
            configuration = configuration)
    }
    if(item.isChatOpened && !item.isLastContentSendToSender){
        if(item.lastContentType!= ContentType.Chat) {
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
        AutoSizeText(
            factor=0.85f,
            text = "Opened",
            textColor = ThemeColors.LIGHT_TINT_TEXT,
            fontWeight=FontWeight.W400,
            textStyle = TextStyle(fontSize = 14.sp),
            configuration = configuration)
    }
    if(item.isChatOpened && item.isLastContentSendToSender){
        if(item.isChatUnseenBySender) {
            if(item.lastContentType != ContentType.Chat) {
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
            AutoSizeText(
                factor=0.85f,
                text = "Delivered",
                textColor = ThemeColors.LIGHT_TINT_TEXT,
                fontWeight=FontWeight.W400,
                textStyle = TextStyle(fontSize = 14.sp),
                configuration = configuration)
        }else{
            if(item.lastContentType != ContentType.Chat) {
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
            AutoSizeText(
                factor=0.85f,
                text = "Opened",
                textColor = ThemeColors.LIGHT_TINT_TEXT,
                fontWeight=FontWeight.W400,
                textStyle = TextStyle(fontSize = 14.sp),
                configuration = configuration)
        }

    }
}