package com.debanshu777.snapchatUIComposeClone.features.feature_stories.domain.model

import android.media.Image
import com.debanshu777.snapchatUIComposeClone.common.domain.model.SnapDurationType
import com.debanshu777.snapchatUIComposeClone.common.domain.model.User
import com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain.ContentType

data class Story(
    val userId: Long,
    val timeStamp:Long,
    val contentType: ContentType,
    val media:Image,
    val snapDurationType: SnapDurationType
)
