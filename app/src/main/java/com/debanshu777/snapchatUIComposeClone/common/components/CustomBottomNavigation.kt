package com.debanshu777.snapchatUIComposeClone.common.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.debanshu777.snapchatUIComposeClone.common.utils.ThemeColors
import com.debanshu777.snapchatUIComposeClone.common.domain.model.BottomNavItem

@ExperimentalMaterialApi
@Composable
fun CustomBottomNavigation(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier =Modifier,
    onItemClick: (BottomNavItem)-> Unit
){
    val backStackEntry =navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.Black,
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                modifier=Modifier.padding(10.dp),
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor =item.onSelectedColor,
                unselectedContentColor = ThemeColors.LIGHT_ICON_TINT,
                icon = {
                    Column(horizontalAlignment = CenterHorizontally) {
                        if (item.onSelectedBatchVisible){
                            BadgeBox(
                                backgroundColor = item.onSelectedColor,
                            ) {
                                Icon(
                                    modifier = Modifier.size(30.dp),
                                    imageVector = item.icon,
                                    contentDescription = item.name
                                )
                            }
                        }else{
                            if(selected && item.name=="Camara"){
                                CustomCamaraOnSelectItem(item.onSelectIcon,item.onSelectedColor)
                            }else {
                                Icon(
                                    modifier = Modifier.size(30.dp),
                                    imageVector = item.icon,
                                    contentDescription = item.name
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

