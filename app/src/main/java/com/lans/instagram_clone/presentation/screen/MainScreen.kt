package com.lans.instagram_clone.presentation.screen

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.lans.instagram_clone.presentation.component.bottom_navigation.BottomNavigationBar
import com.lans.instagram_clone.presentation.component.bottom_navigation.BottomNavigationItem
import com.lans.instagram_clone.presentation.component.top_navigation.HomeAppBar
import com.lans.instagram_clone.presentation.navigation.MainRoute
import com.lans.instagram_clone.presentation.navigation.graph.MainNavGraph

@Composable
fun MainScreen(
    rootNavController: NavHostController
) {
    val mainNavController = rememberNavController()
    val activity = LocalContext.current as Activity
    val navBackStackEntry by mainNavController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination
    BackHandler {
        if(currentRoute?.route == MainRoute.HomeScreen.route) {
            activity.finish()
        }
    }
    Scaffold(
        topBar = { HomeAppBar() },
        bottomBar = { BottomNavigationBar(
            navigateToHome =  { mainNavController.navigate(MainRoute.HomeScreen.route) },
            navigateToSearch =  { mainNavController.navigate(MainRoute.SearchScreen.route) },
            navigateToLikes =  { mainNavController.navigate(MainRoute.LikesScreen.route) },
            navigateToProfile =  { mainNavController.navigate(MainRoute.ProfileScreen.route) }
        ) }
    ) { paddingValues ->
        MainNavGraph(
            rootNavController = rootNavController,
            mainNavController = mainNavController,
            innerPadding = paddingValues
        )
    }
}