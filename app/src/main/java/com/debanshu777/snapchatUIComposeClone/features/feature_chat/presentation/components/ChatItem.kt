package com.debanshu777.snapchatUIComposeClone.features.feature_chat.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CameraAlt
import androidx.compose.material.icons.outlined.ChatBubbleOutline
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.debanshu777.snapchatUIComposeClone.R
import com.debanshu777.snapchatUIComposeClone.common.components.AutoSizeText
import com.debanshu777.snapchatUIComposeClone.common.utils.ThemeColors
import com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain.ChatView
import com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain.ContentType
import com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain.LastContentTimeType

/**
 * Chat item preview
 *
 */
@Preview
@Composable
fun ChatItemPreview() {
    ChatItem(
        modifier = Modifier
            .background(color = Color.White)
            .padding(10.dp),
        item =
        ChatView(
            sender = "John Doe",
            senderUserId = 1234,
            senderImage = R.drawable.bit1,
            lastContentType = ContentType.Chat,
            isChatUnseenBySender = false,
            isLastContentSendToSender = false,
            isChatOpened = false,
            lastChat = "Hi there",
            lastContentTimeType = LastContentTimeType.Month,
            lastContentTime = "1",
        )
    )
}

/**
 * Chat item
 *
 * @param modifier
 * @param item
 */
@Composable
fun ChatItem(
    modifier: Modifier = Modifier,
    item: ChatView
) {
    val configuration = LocalConfiguration.current
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            Box(
                modifier = Modifier
                    .size(53.25.dp)
                    .clip(CircleShape)
                    .background(color = Color.White)
            ) {
                Image(
                    modifier = Modifier
                        .size(53.25.dp)
                        .clip(CircleShape),
                    painter = painterResource(item.senderImage),
                    contentDescription = "Content description for visually bitmoji"
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                AutoSizeText(
                    factor = 0.85f,
                    text = item.sender,
                    textColor = ThemeColors.DARK_TINT_TEXT,
                    fontWeight = FontWeight.W600,
                    textStyle = TextStyle(fontSize = 20.sp),
                    configuration = configuration
                )
                Row(
                    modifier = Modifier.clip(RoundedCornerShape(10.dp)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ChatTypeItem(item, configuration)
                    Spacer(Modifier.width(10.dp))
                    Box(
                        modifier = Modifier
                            .size(5.dp)
                            .clip(CircleShape)
                            .background(color = ThemeColors.LIGHT_TINT_TEXT)
                    )
                    Spacer(Modifier.width(10.dp))
                    AutoSizeText(
                        factor = 0.85f,
                        text = item.lastContentTime + item.lastContentTimeType.timeType,
                        textColor = ThemeColors.LIGHT_TINT_TEXT,
                        textStyle = TextStyle(fontSize = 14.sp),
                        configuration = configuration
                    )
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (!item.isChatOpened) Divider(
                modifier = Modifier
                    .background(color = ThemeColors.LIGHTER_ICON_TINT)
                    .height(40.dp)
                    .width(0.5.dp),
            )
            Icon(
                modifier = Modifier
                    .size(50.dp)
                    .padding(start = 20.dp, end = 5.dp),
                imageVector = if (item.isChatOpened)
                    Icons.Outlined.CameraAlt
                else
                    Icons.Outlined.ChatBubbleOutline,
                contentDescription = "",
                tint = ThemeColors.LIGHTER_ICON_TINT
            )
            Spacer(modifier = Modifier.width(5.dp))
        }
    }
    Divider(color = Color(0xFFE4E4E4), thickness = 0.1.dp)
}

/**
 * Give color
 *
 * @param item
 * @return
 */
fun giveColor(item: ChatView): Color = if (item.lastContentType == ContentType.Image)
    ThemeColors.RED
else {
    if (item.lastContentType == ContentType.Video)
        ThemeColors.PURPLE
    else
        ThemeColors.BLUE
}
