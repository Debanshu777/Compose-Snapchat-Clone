package com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain

import android.media.Image
import com.debanshu777.snapchatUIComposeClone.common.domain.model.SnapDurationType

/**
 * Snap Data Class
 *
 * @property contentType
 * @property image
 * @property durationType
 * @constructor Create empty Snap
 */
data class Snap(
    val contentType: ContentType,
    val image: Image,
    val durationType: SnapDurationType
)
