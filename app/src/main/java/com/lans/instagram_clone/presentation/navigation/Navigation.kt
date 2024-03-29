package com.lans.instagram_clone.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lans.instagram_clone.presentation.screen.login.LoginScreen
import com.lans.instagram_clone.presentation.screen.register.RegisterScreen

@Composable
fun Navigation(
    startDestination: Route
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination.route
    ) {
        composable(
            route = Route.LoginScreen.route
        ) {
            LoginScreen(navController = navController)
        }
        composable(
            route = Route.RegisterScreen.route,
        ) {
            RegisterScreen(navController = navController)
        }
    }
}