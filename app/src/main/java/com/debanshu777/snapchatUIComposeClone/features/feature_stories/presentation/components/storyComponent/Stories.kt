package com.debanshu777.snapchatUIComposeClone.features.feature_stories.presentation.components.storyComponent

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

/**
 * Stories
 *
 * @param numberOfPages
 * @param modifier
 * @param touchToPause
 * @param content
 * @receiver
 */
@OptIn(ExperimentalPagerApi::class, ExperimentalComposeUiApi::class)
@Composable
fun Stories(
    numberOfPages: Int,
    modifier: Modifier = Modifier,
    touchToPause: Boolean = true,
    content: @Composable (Int) -> Unit,
) {
    val pagerState = rememberPagerState(numberOfPages)

    var pauseTimer by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        //Full screen content behind the indicator
        StoryImage(pagerState = pagerState, onTap = {
            if (touchToPause)
                pauseTimer = it
        }, content)
    }

}
