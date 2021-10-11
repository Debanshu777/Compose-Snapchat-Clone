package com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain

sealed class ContentType(val type:String){
    object video: ContentType("video")
    object image: ContentType("image")
    object chat: ContentType("chat")
}
