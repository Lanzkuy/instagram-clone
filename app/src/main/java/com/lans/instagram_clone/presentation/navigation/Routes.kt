package com.lans.instagram_clone.presentation.navigation

object NavGraph {
    const val RootGraph = "rootGraph"
    const val AuthGraph = "authGraph"
    const val MainGraph = "mainGraph"
}

sealed class AuthRoute(val route: String) {
    object LoginScreen: AuthRoute("login")
    object RegisterScreen: AuthRoute("register")
    object ForgotScreen: AuthRoute("forgot")
}

sealed class MainRoute(val route: String) {
    object HomeScreen: MainRoute("home")
    object SearchScreen: MainRoute("search")
    object LikesScreen: MainRoute("likes")
    object ProfileScreen: MainRoute("profile")
}