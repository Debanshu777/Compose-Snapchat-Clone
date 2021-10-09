package com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain

import android.media.Image
import com.debanshu777.snapchatUIComposeClone.common.domain.model.SnapDurationType

data class Snap(
    val contentType: ContentType,
    val image: Image,
    val durationType: SnapDurationType
)