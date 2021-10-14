package com.debanshu777.snapchatUIComposeClone.features.feature_chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.debanshu777.snapchatUIComposeClone.features.feature_chat.data.dataSource.dummyDataChatViewList
import com.debanshu777.snapchatUIComposeClone.features.feature_chat.presentation.components.ChatItem

@Composable
fun ChatScreen() {
    val chatList= dummyDataChatViewList()
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp))
            .background(color = Color.White)
            .fillMaxSize(),
    ) {
        LazyColumn{
            items(chatList.size) { index->
                ChatItem(
                    modifier=Modifier.padding(10.dp),
                    chatList[index]
                )
            }
        }
    }
}