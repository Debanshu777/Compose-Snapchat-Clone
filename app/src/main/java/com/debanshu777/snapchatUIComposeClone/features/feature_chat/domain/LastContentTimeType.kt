package com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain

sealed class LastContentTimeType(val timeType:String){
    object Month: LastContentTimeType("mo")
    object Week: LastContentTimeType("w")
    object Hour:LastContentTimeType("h")
}
