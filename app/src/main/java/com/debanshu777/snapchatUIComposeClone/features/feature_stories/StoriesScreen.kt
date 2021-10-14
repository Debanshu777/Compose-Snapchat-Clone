package com.debanshu777.snapchatUIComposeClone.features.feature_stories

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.debanshu777.snapchatUIComposeClone.features.feature_stories.presentation.DiscoverView
import com.debanshu777.snapchatUIComposeClone.features.feature_stories.presentation.FriendStories
import com.debanshu777.snapchatUIComposeClone.features.feature_stories.presentation.RectangularStoryView
import com.debanshu777.snapchatUIComposeClone.features.feature_stories.presentation.SubscriptionView

@ExperimentalFoundationApi
@ExperimentalCoilApi
@Composable
@Preview
fun StoriesScreen() {
    val elements =5
    val cols =5
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .clip(RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp)),
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
                    text = "Discover",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 10.dp,top= 20.dp)
                )
            }
            items(elements/2){ row ->
                Row {
                        RectangularStoryView(
                            shadowHeight=160,
                            modifier= Modifier
                                .height(280.dp)
                                .width(200.dp)
                                .padding(end = 10.dp, bottom = 10.dp)
                                .background(color = Color.DarkGray, RoundedCornerShape(5.dp))
                        )
                    RectangularStoryView(
                        shadowHeight=160,
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