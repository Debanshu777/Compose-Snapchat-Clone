package com.debanshu777.snapchatUIComposeClone.common.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.debanshu777.snapchatUIComposeClone.common.domain.model.BottomNavItem

/**
 * Custom bottom navigation
 *
 * @param items
 * @param navController
 * @param modifier
 * @param onItemClick
 * @receiver
 */
@Composable
fun CustomBottomNavigation(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val configuration = LocalConfiguration.current
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomAppBar(
        modifier = modifier,
        containerColor = Color.Transparent,
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            Box(
                modifier = modifier
                    .fillMaxSize()
                    .weight(1f)
                    .padding(top = 15.dp)
                    .clickable { onItemClick(item) },
                contentAlignment = Center
            ) {
                Column(horizontalAlignment = CenterHorizontally) {
                    if (item.onSelectedBatchVisible) {
                        AutoSizeIcon(
                            size = 1.dp,
                            tint = if (selected) item.onSelectedColor else Color.White,
                            icon = item.icon,
                            factor = 15f,
                            badgeColor = item.onSelectedColor,
                            configuration = configuration,
                            contentDescription = item.name,
                            isBadge = true,
                        )
                    } else {
                        AutoSizeIcon(
                            size = 1.dp,
                            tint = if (selected) item.onSelectedColor else Color.White,
                            icon = item.icon,
                            factor = 15f,
                            badgeColor = item.onSelectedColor,
                            configuration = configuration,
                            contentDescription = item.name,
                        )
                    }
                    if (selected) {
                        Icon(
                            modifier = Modifier.height(15.dp),
                            imageVector = Icons.Default.ArrowDropUp,
                            contentDescription = item.name,
                            tint = item.onSelectedColor
                        )
                    } else {
                        Spacer(modifier = Modifier.height(15.dp))
                    }
                }
            }
        }
    }
}
