package com.debanshu777.snapchatUIComposeClone.common.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.debanshu777.snapchatUIComposeClone.R
import com.debanshu777.snapchatUIComposeClone.common.domain.model.TopBarItem

/**
 * Custom top bar
 *
 * @param modifier
 * @param topBarItem
 */
@ExperimentalMaterialApi
@Composable
fun CustomTopBar(
    modifier: Modifier = Modifier,
    topBarItem: TopBarItem
) {
    val configuration = LocalConfiguration.current

    TopAppBar(
        contentPadding = PaddingValues(top = 10.dp, start = 10.dp, end = 10.dp),
        modifier = modifier,
        elevation = 0.dp,
        backgroundColor =
        if (topBarItem.isBackgroundTransparent)
            Color.Transparent
        else
            Color.White,
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.CenterVertically),
            ) {
                Row {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(topBarItem.backgroundTintForIcon)
                    ) {
                        Image(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape),
                            painter = painterResource(R.drawable.bitmoji),
                            contentDescription = "Content description for visually bitmoji"
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(topBarItem.backgroundTintForIcon)
                    ) {
                        AutoSizeIcon(
                            size = 1.dp,
                            icon = Icons.Default.Search,
                            factor = 17f,
                            tint = topBarItem.iconTint,
                            badgeColor = Color.White,
                            configuration = configuration,
                            contentDescription = "Search",
                        )
                    }
                }
                AutoSizeText(
                    factor = 0.85f,
                    text = topBarItem.name,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 5.dp),
                    textColor = topBarItem.textColor,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    textStyle = TextStyle(fontSize = 22.sp),
                    configuration = configuration
                )
                Box(
                    Modifier.align(Alignment.TopEnd)
                ) {
                    if (topBarItem.isAvailable) {
                        CustomActionBar(topBarItem, configuration)
                    }
                }
            }
        }
    )
}
