package com.debanshu777.snapchatUIComposeClone.features.feature_snap_map.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.debanshu777.snapchatUIComposeClone.R

@Composable
fun MapBottomNavigation(){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
        BottomOptionItem(text = "My Bitmoji", imageResource = R.drawable.bitmoji)
        BottomOptionItem(text = "Places", imageResource = R.drawable.places)
        BottomOptionItem(text = "Friends", imageResource = R.drawable.group_image)
    }
}