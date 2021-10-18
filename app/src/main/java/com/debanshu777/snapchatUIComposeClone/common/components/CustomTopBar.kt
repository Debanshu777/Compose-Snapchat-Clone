package com.debanshu777.snapchatUIComposeClone.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.debanshu777.snapchatUIComposeClone.common.domain.model.TopBarItem

@Composable
fun CustomTopBar(
    modifier: Modifier=Modifier,
    topBarItem: TopBarItem
){
    TopAppBar(
        contentPadding= PaddingValues(top=30.dp, start=10.dp, end=10.dp),
        modifier = modifier,
        elevation= 0.dp,
        backgroundColor =
            if(topBarItem.isBackgroundTransparent)
                Color.Transparent
            else
                Color.White,
        content = {
            Box(
               modifier= Modifier
                   .fillMaxSize()
                   .align(Alignment.CenterVertically),
            ) {
                Row{
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(topBarItem.backgroundTintForIcon)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(topBarItem.backgroundTintForIcon)
                    ) {
                        Icon(
                            modifier = Modifier.size(25.dp),
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = topBarItem.iconTint
                        )
                    }
                }
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 5.dp),
                    textAlign= TextAlign.Center ,
                    text = topBarItem.name,
                    color=topBarItem.textColor,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
                Box(
                    Modifier.align(Alignment.TopEnd)
                ) {
                    if(topBarItem.isAvailable) {
                        CustomAction(topBarItem)
                    }
                }
            }
        }
    )
}