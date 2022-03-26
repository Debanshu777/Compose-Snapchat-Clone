package com.debanshu777.snapchatUIComposeClone.common.domain.model

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * User Data Class
 *
 * @property name
 * @property username
 * @property avatar
 * @property zodiac
 * @property phoneNumber
 * @property snapCount
 * @property snapCode
 * @property email
 * @property birthday
 * @constructor Create empty User
 */
data class User(
    val name: String,
    val username: String,
    val avatar: ImageVector,
    val zodiac: String,
    val phoneNumber:Long,
    val snapCount:Long,
    val snapCode:Long,
    val email: String,
    val birthday: String,
)
