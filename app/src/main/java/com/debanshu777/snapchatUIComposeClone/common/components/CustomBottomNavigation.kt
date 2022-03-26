package com.debanshu777.snapchatUIComposeClone.common.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.debanshu777.snapchatUIComposeClone.common.domain.model.BottomNavItem
import com.debanshu777.snapchatUIComposeClone.common.utils.ThemeColors

/**
 * Custom bottom navigation
 *
 * @param items
 * @param navController
 * @param modifier
 * @param onItemClick
 * @receiver
 */
@ExperimentalMaterialApi
@Composable
fun CustomBottomNavigation(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier =Modifier,
    onItemClick: (BottomNavItem)-> Unit
){
    val configuration = LocalConfiguration.current
    val backStackEntry =navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.Black,
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                modifier=Modifier.padding(),
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor =item.onSelectedColor,
                unselectedContentColor = ThemeColors.LIGHT_ICON_TINT,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        if (item.onSelectedBatchVisible){
                            AutoSizeIcon(
                                size = 1.dp,
                                icon = item.icon,
                                factor=15f,
                                badgeColor = item.onSelectedColor,
                                configuration = configuration,
                                contentDescription = item.name,
                                isBadge = true,
                            )
                        }else{
                            if(selected && item.name=="Camara"){
                                CustomCamaraOnSelectItem(
                                    item.onSelectedColor,
                                    configuration,
                                    item.name
                                )
                            }else {
                                AutoSizeIcon(
                                    size = 1.dp,
                                    icon = item.icon,
                                    factor=15f,
                                    badgeColor = item.onSelectedColor,
                                    configuration = configuration,
                                    contentDescription = item.name,
                                )
                            }
                        }
                        if(selected && item.name!="Camara"){
                            Icon(
                                modifier = Modifier.height(15.dp),
                                imageVector = Icons.Default.ArrowDropUp,
                                contentDescription = item.name
                            )
                        }else{
                            Spacer(modifier = Modifier.height(15.dp))
                        }
                    }

                }
            )
        }
    }
}

