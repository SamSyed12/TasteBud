package com.example.tastebud.navigation

sealed class Screen(val route: String, val screenTitle: String) {
    object Login : Screen(route = "login", screenTitle = "")
    object Home : Screen(route = "home", screenTitle = "Home")
    object Tips : Screen(route = "tips", screenTitle = "Tips")
    object MyPage : Screen(route = "my_page", screenTitle = "My Page")
}