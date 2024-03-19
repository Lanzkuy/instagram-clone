package com.lans.instagram_clone.presentation.navigation.graph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lans.instagram_clone.presentation.navigation.MainRoute
import com.lans.instagram_clone.presentation.screen.home.HomeScreen

@Composable
fun MainNavGraph(
    rootNavController: NavController,
    mainNavController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = mainNavController,
        startDestination = MainRoute.HomeScreen.route
    ) {
        composable(route = MainRoute.HomeScreen.route) {
            HomeScreen(innerPadding = innerPadding)
        }
        composable(route = MainRoute.SearchScreen.route) {
            //SearchScreen(innerPadding = innerPadding)
        }
        composable(route = MainRoute.LikesScreen.route) {
            //LikesScreen(innerPadding = innerPadding)
        }
        composable(route = MainRoute.ProfileScreen.route) {
            //ProfileScreen(innerPadding = innerPadding)
        }
    }
}