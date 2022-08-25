package com.debanshu777.snapchatUIComposeClone.features.feature_stories.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.debanshu777.snapchatUIComposeClone.features.feature_stories.domain.model.Subscription

/**
 * Rectangular story view
 *
 * @param shadowHeight
 * @param isLarge
 * @param height
 * @param modifier
 * @param subscription
 */
@ExperimentalCoilApi
@Composable
fun RectangularStoryView(
    shadowHeight: Float,
    isLarge: Boolean,
    modifier: Modifier,
    subscription: Subscription
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(5.dp),
    ) {
        Box(Modifier.fillMaxHeight()) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current)
                        .data(data = subscription.coverImageURL)
                        .build()
                ),
                contentScale = ContentScale.Crop,
                contentDescription = "Content",
            )
            Box(
                modifier = Modifier
                    .matchParentSize()
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
                    .padding(if (!isLarge) 5.dp else 10.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = subscription.title,
                    maxLines = if (!isLarge) 2 else 4,
                    color = Color.White,
                    fontWeight = FontWeight.W800,
                    fontSize = if (!isLarge) 12.sp else 20.sp,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}
