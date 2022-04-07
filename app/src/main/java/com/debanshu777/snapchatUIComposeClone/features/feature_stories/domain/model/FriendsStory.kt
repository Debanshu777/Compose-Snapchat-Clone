package com.debanshu777.snapchatUIComposeClone.features.feature_stories.domain.model

/**
 * Friends story Data Class
 *
 * @property userName
 * @property stories
 * @property storyCount
 * @property thumbnail
 * @constructor Create empty Friends story
 */
data class FriendsStory(
    val userName: String,
    val stories: List<Story>,
    val storyCount: Int,
    val thumbnail: String
)
