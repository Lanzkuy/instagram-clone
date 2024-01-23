package com.lans.instagram_clone.presentation.navigation

sealed class Route(val route: String) {
    object LoginScreen: Route("login")
    object RegisterScreen: Route("register")
    object HomeScreen: Route("home")
}
