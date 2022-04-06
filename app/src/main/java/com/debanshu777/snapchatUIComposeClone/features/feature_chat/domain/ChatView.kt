package com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain

/**
 * Chat view Data Class
 *
 * @property sender
 * @property senderUserId
 * @property senderImage
 * @property lastContentType
 * @property isChatUnseenBySender
 * @property isChatOpened
 * @property isLastContentSendToSender
 * @property lastChat
 * @property lastContentTime
 * @property lastContentTimeType
 * @constructor Create empty Chat view
 */
data class ChatView(
    val sender: String,
    val senderUserId: Long,
    val senderImage: Int,
    val lastContentType: ContentType,
    val isChatUnseenBySender: Boolean,
    val isChatOpened: Boolean,
    val isLastContentSendToSender: Boolean,
    val lastChat: String,
    val lastContentTime: String,
    val lastContentTimeType: LastContentTimeType
)
