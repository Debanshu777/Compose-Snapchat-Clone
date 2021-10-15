package com.debanshu777.snapchatUIComposeClone.features.feature_stories.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.debanshu777.snapchatUIComposeClone.common.utils.Messages
import com.debanshu777.snapchatUIComposeClone.common.utils.ThemeColors

@Composable
fun FriendStories(){
    Column(
      modifier = Modifier.padding(top=70.dp)
    ) {
        Text(
            text = Messages.FRIENDS_SUB_HEADING,
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        LazyRow{
            items(5){index->
                StoryItem()
            }
        }
    }
}

@Composable
fun StoryItem(){
    Column(
        modifier = Modifier.padding(end = 15.dp, top = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier= Modifier
                .border(
                    BorderStroke(2.dp, color = ThemeColors.PURPLE),
                    CircleShape
                )
                .size(80.dp),
            contentAlignment = Alignment.Center
        ){
            Box(
                modifier= Modifier
                    .size(72.dp)
                    .background(Color.DarkGray, CircleShape)
            ){
            }
        }
        Text(
            modifier=Modifier.width(70.dp),
            fontSize=13.sp,
            text = "Chhabi Lal Dhruw",
            color=Color.Black,
            overflow = TextOverflow.Clip,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W300
        )
    }
}