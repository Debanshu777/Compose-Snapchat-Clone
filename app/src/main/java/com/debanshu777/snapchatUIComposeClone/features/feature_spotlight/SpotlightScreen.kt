package com.debanshu777.snapchatUIComposeClone.features.feature_spotlight

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.debanshu777.snapchatUIComposeClone.features.feature_spotlight.data.datasource.DummySpotlightData
import com.debanshu777.snapchatUIComposeClone.features.feature_spotlight.domain.model.Spotlight
import com.debanshu777.snapchatUIComposeClone.features.feature_spotlight.presentation.components.VideoPlayer
import com.skydoves.landscapist.glide.GlideImage

val verticalPadding = 12.dp
val horizontalPadding = 10.dp

@Composable
fun SpotlightScreen() {
    Box(
        Modifier
            .background(color = Color.Black)
            .padding(bottom = 40.dp)) {
        SpotlightList()
    }
}

@Composable
fun SpotlightList() {
    val spotlights = DummySpotlightData.spotlight
    val columnState = rememberLazyListState()
    LazyColumn(flingBehavior = ScrollableDefaults.flingBehavior()){
        items(spotlights.size) {index ->
            Box(Modifier.fillParentMaxSize()) {
                VideoPlayer(uri = spotlights[index].getVideoUrl())
                Column(Modifier.align(Alignment.BottomStart)) {
                    SpotlightFooter(spotlights[index])
                    Divider()
                }
            }
        }
    }
}

@Composable
fun SpotlightFooter(spotlight: Spotlight) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(start = 18.dp, bottom = 18.dp), verticalAlignment = Alignment.Bottom) {
        FooterUserData(
            spotlight = spotlight,
            modifier = Modifier.weight(8f)
        )

        FooterUserAction(
            spotlight = spotlight,
            modifier = Modifier.weight(2f)
        )
    }
}

@Composable
fun FooterUserAction(spotlight: Spotlight, modifier: Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        UserAction(
            icon = Icons.Outlined.Favorite,
            text = spotlight.likesCount.toString()
        )
        Spacer(modifier = Modifier.height(10.dp))
        UserAction(
            icon = Icons.Default.Send,
            text = spotlight.commentsCount.toString()
        )
        Spacer(modifier = Modifier.height(10.dp))
        UserAction(
            icon = Icons.Default.MoreHoriz,
            text = spotlight.commentsCount.toString()
        )
    }
}

@Composable
fun UserAction(
    icon: ImageVector,
    text: String
) {
    Icon(
        imageVector = icon,
        tint = Color.White,
        modifier = Modifier
            .clip(CircleShape)
            .background(color = Color.DarkGray)
            .padding(10.dp)
            .size(28.dp),
        contentDescription = null
    )
}

@Composable
fun FooterUserData(spotlight: Spotlight, modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            GlideImage(imageModel = spotlight.userImage,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(28.dp)
                    .background(color = Color.Gray, shape = CircleShape)
                    .clip(CircleShape),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(horizontalPadding))
            Text(
                text = "@${spotlight.userName}",
                color = Color.White,
                fontWeight= FontWeight.Bold,
                style = MaterialTheme.typography.h6
            )

            Spacer(modifier = Modifier.width(horizontalPadding))
            Icon(
                modifier=Modifier.size(20.dp),
                imageVector = Icons.Outlined.BookmarkBorder,
                contentDescription = "Bookmark"
            )
            Icon(
                modifier=Modifier.size(15.dp),
                imageVector = Icons.Outlined.Add,
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.height(horizontalPadding))

        // Audio
        Row(
            modifier = Modifier
                .background(color = Color.DarkGray)
                .padding(10.dp)
                .clip(RoundedCornerShape(10.dp)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                modifier=Modifier.size(15.dp),
                imageVector = Icons.Outlined.GraphicEq,
                contentDescription = "Bookmark"
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "@${spotlight.userName}'s Sound",
                color = Color.White,
                style = MaterialTheme.typography.body2
            )
        }
    }
}