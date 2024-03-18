package com.lans.instagram_clone.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lans.instagram_clone.presentation.navigation.NavGraph
import com.lans.instagram_clone.presentation.screen.MainScreen

@Composable
fun RootNavGraph(
    startDestination: String
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        route = NavGraph.RootGraph,
        startDestination = startDestination
    ) {
        authNavGraph(navController = navController)
        composable(route = NavGraph.MainGraph) {
            MainScreen(rootNavController = navController)
        }
    }
}