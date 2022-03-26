package com.debanshu777.snapchatUIComposeClone.features.feature_spotlight.domain.model

import android.net.Uri

/**
 * Spotlight Data Class
 *
 * @property id
 * @property video
 * @property userImage
 * @property userName
 * @property isLiked
 * @property likesCount
 * @property comment
 * @property commentsCount
 * @constructor Create empty Spotlight
 */
data class Spotlight(
    val id: Int,
    private val video: String,
    val userImage: String,
    val userName: String,
    val isLiked: Boolean = false,
    val likesCount: Int,
    val comment: String,
    val commentsCount: Int
) {
    /**
     * Get video url
     *
     * @return
     */
    fun getVideoUrl(): Uri {
        return Uri.parse("asset:///${video}")
    }
}