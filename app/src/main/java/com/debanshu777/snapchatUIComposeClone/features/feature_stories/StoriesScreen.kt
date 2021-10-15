package com.debanshu777.snapchatUIComposeClone.features.feature_stories

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.debanshu777.snapchatUIComposeClone.common.utils.Messages
import com.debanshu777.snapchatUIComposeClone.features.feature_stories.presentation.components.FriendStories
import com.debanshu777.snapchatUIComposeClone.features.feature_stories.presentation.components.SubscriptionView
import com.debanshu777.snapchatUIComposeClone.features.feature_stories.presentation.components.RectangularStoryView

@ExperimentalFoundationApi
@ExperimentalCoilApi
@Composable
@Preview
fun StoriesScreen() {
    val elements =5
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp))
            .background(Color.White)
            .fillMaxSize(),
    ) {
        LazyColumn(
            modifier = Modifier.padding(start=10.dp)
        ) {
            item{
                FriendStories()
            }
            item{
                SubscriptionView()
            }
            item{
                Text(
                    text = Messages.DISCOVER_SUB_HEADING,
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 10.dp,top= 20.dp)
                )
            }
            items(elements/2){ row ->
                Row {
                        RectangularStoryView(
                            shadowHeight=230f,
                            height=200.dp,
                            isLarge=true,
                            modifier= Modifier
                                .height(280.dp)
                                .width(200.dp)
                                .padding(end = 10.dp, bottom = 10.dp)
                                .background(color = Color.DarkGray, RoundedCornerShape(5.dp))
                        )
                    RectangularStoryView(
                        shadowHeight=230f,
                        height=200.dp,
                        isLarge=true,
                        modifier= Modifier
                            .height(280.dp)
                            .width(200.dp)
                            .padding(end = 10.dp,bottom = 10.dp)
                            .background(color = Color.DarkGray, RoundedCornerShape(5.dp))
                    )
                }

            }
        }
    }
}