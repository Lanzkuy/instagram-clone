package com.lans.instagram_clone.presentation.component.bottom_navigation

import com.lans.instagram_clone.R
import com.lans.instagram_clone.presentation.navigation.MainRoute

data class BottomNavigationItem(
    val title: String = "",
    val route: MainRoute = MainRoute.HomeScreen,
    val selectedIcon: Int = 0,
    val unselectedIcon: Int = 0
) {
    fun items(): List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                title = "Home",
                route = MainRoute.HomeScreen,
                selectedIcon = R.drawable.ic_home_active,
                unselectedIcon = R.drawable.ic_home_deactive
            ),
            BottomNavigationItem(
                title = "Search",
                route = MainRoute.SearchScreen,
                selectedIcon = R.drawable.ic_search_active,
                unselectedIcon = R.drawable.ic_search_deactive
            ),
            BottomNavigationItem(
                title = "Likes",
                route = MainRoute.LikesScreen,
                selectedIcon = R.drawable.ic_heart_active,
                unselectedIcon = R.drawable.ic_heart_deactive
            ),
            BottomNavigationItem(
                title = "Profile",
                route = MainRoute.ProfileScreen,
                selectedIcon = R.drawable.ic_profile,
                unselectedIcon = R.drawable.ic_profile
            ),
        )
    }
}
