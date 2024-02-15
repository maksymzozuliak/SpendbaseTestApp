package com.zozuliak.spendbasetestapp.utils

sealed class Screen(val route: String) {

    object MainScreen: Screen("main_screen")

    object CardScreen: Screen("card_screen")
}
