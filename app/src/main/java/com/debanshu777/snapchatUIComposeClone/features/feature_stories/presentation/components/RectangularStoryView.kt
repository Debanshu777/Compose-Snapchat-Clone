package com.debanshu777.snapchatUIComposeClone.features.feature_stories.presentation.components

import androidx.annotation.Px
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import java.time.format.TextStyle

@ExperimentalCoilApi
@Composable
fun RectangularStoryView(shadowHeight:Float,isLarge:Boolean,height:Dp,modifier: Modifier){
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(5.dp),
        elevation=5.dp
    ){
        Box(Modifier.height(height)) {
            Image(
                painter = rememberImagePainter(
                    data="https://www.pixsy.com/wp-content/uploads/2021/04/ben-sweet-2LowviVHZ-E-unsplash-1.jpeg",
                    builder = {

                    }
                ),
                contentDescription = "Hello",
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = shadowHeight
                    ),
                )
            )
            Box(
                Modifier
                    .fillMaxSize()
                    .padding(if(!isLarge) 5.dp else 10.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = "Losing Carbon for 5 Secs Is Worse Than You Think",
                    maxLines = 4,
                    color=Color.White,
                    fontWeight= FontWeight.W800,
                    fontSize= if(!isLarge) 12.sp else 20.sp,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }

    }
   
    

}