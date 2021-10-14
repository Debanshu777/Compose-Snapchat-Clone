package com.debanshu777.snapchatUIComposeClone.features.feature_stories.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import coil.Coil
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter


@ExperimentalCoilApi
@Composable
fun SubscriptionView(){
    Column(
       modifier = Modifier.padding(top= 20.dp)
    ) {
        Text(
            text = "Subscriptions",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier =Modifier.padding(bottom = 10.dp)
        )
        LazyRow{
            items(5){index->
                RectangularStoryView(
                    shadowHeight=160,
                    modifier= Modifier
                        .height(160.dp)
                        .width(110.dp)
                        .padding(end = 10.dp)
                        .background(color=Color.DarkGray, RoundedCornerShape(5.dp))
                )
            }
        }
    }
}

@ExperimentalCoilApi
@Composable
fun RectangularStoryView(shadowHeight:Long,modifier:Modifier){
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Black, Color.Transparent),
        startY = shadowHeight.toFloat()/3,
        endY = shadowHeight.toFloat()
    )
    Image(
        modifier=modifier,
        painter = rememberImagePainter(
            data="https://www.pixsy.com/wp-content/uploads/2021/04/ben-sweet-2LowviVHZ-E-unsplash-1.jpeg",
            builder = {
                crossfade(true)
            }
        ),
        contentScale=ContentScale.Crop,
        contentDescription = "",
    )

}