package com.debanshu777.snapchatUIComposeClone.features.feature_spotlight.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.GraphicEq
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.debanshu777.snapchatUIComposeClone.common.utils.ThemeColors
import com.debanshu777.snapchatUIComposeClone.features.feature_spotlight.domain.model.Spotlight
import com.debanshu777.snapchatUIComposeClone.features.feature_spotlight.horizontalPadding

/**
 * Footer user data
 *
 * @param spotlight
 * @param modifier
 */
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
            Box(
                modifier=Modifier.height(28.dp).width(28.dp),
                contentAlignment = Alignment.Center
            ) {
                val painter = rememberImagePainter(
                    data = "https://avatars.githubusercontent.com/u/50791485?v=4",
                    builder = {
                        transformations(
                            CircleCropTransformation()
                        )
                    }
                )
                Image(
                    painter = painter,
                    contentDescription = null,
                )
            }
            Spacer(modifier = Modifier.width(horizontalPadding))
            Text(
                text = "@${spotlight.userName}",
                color = Color.White,
                fontWeight= FontWeight.Bold,
                style = MaterialTheme.typography.h6
            )

            Spacer(modifier = Modifier.width(horizontalPadding))
            Icon(
                modifier= Modifier.size(20.dp),
                imageVector = Icons.Outlined.BookmarkBorder,
                contentDescription = "Bookmark"
            )
            Icon(
                modifier= Modifier.size(15.dp),
                imageVector = Icons.Outlined.Add,
                contentDescription = ""
            )
        }
        Spacer(modifier = Modifier.height(horizontalPadding))

        // Audio
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(color = ThemeColors.DARK_TRANSPARENT)
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                modifier= Modifier.size(15.dp),
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