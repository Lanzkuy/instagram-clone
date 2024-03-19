package com.lans.instagram_clone.presentation.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.lans.instagram_clone.presentation.navigation.AuthRoute
import com.lans.instagram_clone.presentation.navigation.MainRoute
import com.lans.instagram_clone.presentation.navigation.NavGraph
import com.lans.instagram_clone.presentation.screen.login.LoginScreen
import com.lans.instagram_clone.presentation.screen.login.LoginViewModel
import com.lans.instagram_clone.presentation.screen.register.RegisterScreen
import com.lans.instagram_clone.presentation.screen.register.RegisterViewModel

fun NavGraphBuilder.authNavGraph(
    navController: NavController
) {
    navigation(
        route = NavGraph.AuthGraph,
        startDestination = AuthRoute.LoginScreen.route
    ) {
        composable(route = AuthRoute.LoginScreen.route) {
            LoginScreen(
                navigateToRegister = {
                    navController.navigate(route = AuthRoute.RegisterScreen.route) {
                        popUpTo(route = AuthRoute.LoginScreen.route)
                    }
                },
                navigateToHome = {
                    navController.navigate(route = NavGraph.MainGraph) {
                        popUpTo(route = AuthRoute.LoginScreen.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(route = AuthRoute.RegisterScreen.route) {
            RegisterScreen(
                navigateToLogin = {
                    navController.navigateUp()
                }
            )
        }
        composable(route = AuthRoute.ForgotScreen.route) {

        }
    }
}