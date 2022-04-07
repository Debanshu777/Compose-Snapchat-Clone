package com.debanshu777.snapchatUIComposeClone.common.domain.model

/**
 * Snap duration type state
 *
 * @property type
 * @constructor Create empty Snap duration type
 */
sealed class SnapDurationType(private val type: String) {
    object OneTime : SnapDurationType("oneTime")
    object Loop : SnapDurationType("loop")
}
