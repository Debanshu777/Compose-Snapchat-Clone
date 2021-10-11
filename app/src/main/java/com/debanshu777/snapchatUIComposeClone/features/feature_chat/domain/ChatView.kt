package com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain

import com.debanshu777.snapchatUIComposeClone.common.domain.model.User

data class ChatView(
    val sender: User,
    val lastContentType: ContentType,
    val isChatUnseen:Boolean,
    val lastChat: String
)
