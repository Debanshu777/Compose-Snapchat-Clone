package com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain

/**
 * Last content time type Data Class
 *
 * @property timeType
 * @constructor Create empty Last content time type
 */
sealed class LastContentTimeType(val timeType: String) {
    object Month : LastContentTimeType("mo")
    object Week : LastContentTimeType("w")
    object Hour : LastContentTimeType("h")
}
