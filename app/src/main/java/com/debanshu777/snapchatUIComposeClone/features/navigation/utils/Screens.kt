package com.debanshu777.snapchatUIComposeClone.features.navigation.utils

sealed class Screens(val route: String) {
    object CamaraScreen: Screens("camara")
    object ChatScreen: Screens("chat")
    object MemoriesScreen: Screens("memories")
    object SnapMapScreen: Screens("snapMap")
    object SpotlightScreen: Screens("spotlight")
    object StoriesScreen: Screens("stories")
}