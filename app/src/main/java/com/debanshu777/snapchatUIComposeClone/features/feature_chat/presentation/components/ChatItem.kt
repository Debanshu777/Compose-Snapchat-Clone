package com.debanshu777.snapchatUIComposeClone.features.feature_chat.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.debanshu777.snapchatUIComposeClone.common.utils.ThemeColors
import com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain.ChatView
import com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain.ContentType

@Composable
fun ChatItem(
    modifier: Modifier = Modifier,
    item: ChatView
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            Box(
                modifier = Modifier
                    .size(55.dp)
                    .clip(CircleShape)
                    .background(color = Color.DarkGray)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(
                    text = item.sender,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    color = ThemeColors.DARK_TINT_TEXT
                )
                Row(
                    modifier = Modifier.clip(RoundedCornerShape(10.dp)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ChatTypeItem(item)
                    Spacer(Modifier.width(10.dp))
                    Box(
                        modifier = Modifier
                            .size(5.dp)
                            .clip(CircleShape)
                            .background(color = ThemeColors.LIGHT_TINT_TEXT)
                    )
                    Spacer(Modifier.width(10.dp))
                    Text(
                        text = item.lastContentTime+item.lastContentTimeType.timeType,
                        color = ThemeColors.LIGHT_TINT_TEXT
                    )
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if(!item.isChatOpened) Divider(
                modifier = Modifier
                    .background(color = ThemeColors.LIGHTER_ICON_TINT)
                    .height(40.dp)
                    .width(0.5.dp),
            )
            Icon(
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 20.dp,end= 5.dp),
                imageVector = if(item.isChatOpened)
                    Icons.Outlined.CameraAlt
                else
                    Icons.Outlined.ChatBubbleOutline,
                contentDescription = "",
                tint = ThemeColors.LIGHTER_ICON_TINT
            )
            Spacer(modifier = Modifier.width(5.dp))
        }
    }
    Divider(color=Color(0xFFE4E4E4), thickness = 0.2.dp)
}

fun giveColor(item: ChatView) :Color = if(item.lastContentType==ContentType.image)
    ThemeColors.RED
else {
    if (item.lastContentType == ContentType.video)
        ThemeColors.PURPLE
    else
        ThemeColors.BLUE
}