package com.debanshu777.snapchatUIComposeClone.features.feature_chat.data.dataSource

import com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain.ChatView
import com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain.ContentType

fun DummyDataChatViewList(): List<ChatView>{
    return listOf(
        ChatView(
            sender = "Debanshu Datta",
            senderUserId = 1234,
            lastContentType = ContentType.image,
            isChatUnseen = false,
            lastChat = "Hi there"
        ),
        ChatView(
            sender = "Debanshu Datta",
            senderUserId = 1234,
            lastContentType = ContentType.image,
            isChatUnseen = false,
            lastChat = "Hi there"
        ),
        ChatView(
            sender = "Debanshu Datta",
            senderUserId = 1234,
            lastContentType = ContentType.image,
            isChatUnseen = false,
            lastChat = "Hi there"
        ),
        ChatView(
            sender = "Debanshu Datta",
            senderUserId = 1234,
            lastContentType = ContentType.image,
            isChatUnseen = false,
            lastChat = "Hi there"
        ),
        ChatView(
            sender = "Debanshu Datta",
            senderUserId = 1234,
            lastContentType = ContentType.image,
            isChatUnseen = false,
            lastChat = "Hi there"
        ),
        ChatView(
            sender = "Debanshu Datta",
            senderUserId = 1234,
            lastContentType = ContentType.image,
            isChatUnseen = false,
            lastChat = "Hi there"
        )
    )
}