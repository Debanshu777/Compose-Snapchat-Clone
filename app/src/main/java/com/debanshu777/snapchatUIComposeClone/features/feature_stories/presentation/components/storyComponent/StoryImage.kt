package com.debanshu777.snapchatUIComposeClone.features.feature_stories.presentation.components.storyComponent

import android.view.MotionEvent
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInteropFilter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

/**
 * Story image
 *
 * @param pagerState
 * @param onTap
 * @param content
 * @receiver
 * @receiver
 */
@ExperimentalComposeUiApi
@OptIn(ExperimentalPagerApi::class)
@Composable
fun StoryImage(pagerState: PagerState, onTap: (Boolean) -> Unit, content: @Composable (Int) -> Unit) {
    HorizontalPager(
        count = 10, state = pagerState,
        modifier = Modifier.pointerInteropFilter {
            when (it.action) {
                MotionEvent.ACTION_DOWN -> {
                    onTap(true)
                }

                MotionEvent.ACTION_UP -> {
                    onTap(false)
                }
            }
            true
        }
    ) {
        content(it)
    }
}
