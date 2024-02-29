package com.lans.instagram_clone.presentation.component.bottom_navigation

import com.lans.instagram_clone.R

data class BottomNavigationItem(
    val title: String = "",
    val selectedIcon: Int = 0,
    val unselectedIcon: Int = 0
) {
    fun items(): List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                title = "Home",
                selectedIcon = R.drawable.ic_home_active,
                unselectedIcon = R.drawable.ic_home_deactive
            ),
            BottomNavigationItem(
                title = "Search",
                selectedIcon = R.drawable.ic_search_active,
                unselectedIcon = R.drawable.ic_search_deactive
            ),
            BottomNavigationItem(
                title = "Likes",
                selectedIcon = R.drawable.ic_heart_active,
                unselectedIcon = R.drawable.ic_heart_deactive
            ),
            BottomNavigationItem(
                title = "Profile",
                selectedIcon = R.drawable.ic_profile,
                unselectedIcon = R.drawable.ic_profile
            ),
        )
    }
}
