package com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain

/**
 * Content type Data Class
 *
 * @property type
 * @constructor Create empty Content type
 */
sealed class ContentType(val type:String){
    object Video: ContentType("video")
    object Image: ContentType("image")
    object Chat: ContentType("chat")
}
