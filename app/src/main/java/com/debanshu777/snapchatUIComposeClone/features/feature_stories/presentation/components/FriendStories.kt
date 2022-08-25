package com.debanshu777.snapchatUIComposeClone.features.feature_stories.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.debanshu777.snapchatUIComposeClone.common.utils.Messages
import com.debanshu777.snapchatUIComposeClone.common.utils.ThemeColors
import com.debanshu777.snapchatUIComposeClone.features.feature_stories.data.mockDataStories
import com.debanshu777.snapchatUIComposeClone.features.feature_stories.domain.model.FriendsStory

/**
 * Friend stories
 *
 */
@Composable
fun FriendStories() {
    val stories = mockDataStories()
    Column(
        modifier = Modifier.padding(top = 70.dp)
    ) {
        Text(
            text = Messages.FRIENDS_SUB_HEADING,
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        LazyRow {
            items(stories.size) { index ->
                StoryItem(stories[index])
            }
        }
    }
}

/**
 * Story item
 *
 * @param stories
 */
@Composable
fun StoryItem(stories: FriendsStory) {
    Column(
        modifier = Modifier.padding(end = 15.dp, top = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .border(
                    BorderStroke(2.dp, color = ThemeColors.PURPLE),
                    CircleShape
                )
                .size(70.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .padding(5.dp)
                    .clip(CircleShape)
                    .size(70.dp),
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = stories.thumbnail)
                        .build()
                ),
                contentScale = ContentScale.Crop,
                contentDescription = "Content",
            )
        }
        Text(
            modifier = Modifier.width(70.dp),
            fontSize = 13.sp,
            text = stories.userName,
            color = Color.Black,
            overflow = TextOverflow.Clip,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.W300
        )
    }
}
