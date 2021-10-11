package com.debanshu777.snapchatUIComposeClone.common.domain.model

import androidx.compose.ui.graphics.vector.ImageVector

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
