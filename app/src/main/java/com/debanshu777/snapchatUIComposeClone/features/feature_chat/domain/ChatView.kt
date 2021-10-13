package com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain

data class ChatView(
    val sender: String,
    val senderUserId: Long,
    val lastContentType: ContentType,
    val isChatUnseenBySender:Boolean,
    val isChatOpened:Boolean,
    val isLastContentSendToSender:Boolean,
    val lastChat: String,
    val lastContentTime: String,
    val lastContentTimeType: LastContentTimeType
)
