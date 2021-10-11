package com.debanshu777.snapchatUIComposeClone.common.domain.model

sealed class SnapDurationType(val type:String){
    object oneTime:SnapDurationType("oneTime")
    object loop:SnapDurationType("loop")
}
