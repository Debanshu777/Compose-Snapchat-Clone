package com.debanshu777.snapchatUIComposeClone.features.feature_stories.presentation.components

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
import com.debanshu777.snapchatUIComposeClone.common.utils.Messages
import com.debanshu777.snapchatUIComposeClone.features.feature_stories.data.MockDataSubscription
import com.debanshu777.snapchatUIComposeClone.features.feature_stories.presentation.components.RectangularStoryView


@ExperimentalCoilApi
@Composable
fun SubscriptionView(){
    Column(
       modifier = Modifier.padding(top= 20.dp)
    ) {
        val subscriptionList= MockDataSubscription()
        Text(
            text = Messages.SUBSCRIPTION_SUB_HEADING,
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier =Modifier.padding(bottom = 10.dp)
        )
        LazyRow{
            items(subscriptionList.size){index->
                RectangularStoryView(
                    shadowHeight=100f,
                    height=160.dp,
                    subscription=subscriptionList[index],
                    isLarge = false,
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

