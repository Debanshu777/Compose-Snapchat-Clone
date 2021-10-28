package com.debanshu777.snapchatUIComposeClone.common.components

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.size
import androidx.compose.material.BadgeBox
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp

@ExperimentalMaterialApi
@Composable
fun AutoSizeIcon(
    modifier: Modifier = Modifier,
    size: Dp,
    tint:Color?=null,
    factor:Float=1f,
    icon:ImageVector,
    badgeColor: Color,
    configuration: Configuration,
    isBadge: Boolean=false,
    contentDescription:String,
) {
    val factorValue = configuration.screenWidthDp/factor
    Log.e("brotag",(factorValue).toString())

    if(isBadge) {
        BadgeBox(
            backgroundColor = badgeColor,
        ) {
            if (tint != null) {
                Icon(
                    modifier = modifier.size(size * factorValue),
                    imageVector = icon,
                    tint=tint,
                    contentDescription = contentDescription
                )
            }else{
                Icon(
                    modifier = modifier.size(size * factorValue),
                    imageVector = icon,
                    contentDescription = contentDescription
                )
            }
        }
    }else {
        if (tint != null) {
            Icon(
                modifier = modifier.size(size * factorValue),
                imageVector = icon,
                tint=tint,
                contentDescription = contentDescription
            )
        }else{
            Icon(
                modifier = modifier.size(size * factorValue),
                imageVector = icon,
                contentDescription = contentDescription
            )
        }
        }
}