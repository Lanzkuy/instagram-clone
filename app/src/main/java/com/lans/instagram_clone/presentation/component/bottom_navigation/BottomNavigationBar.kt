package com.lans.instagram_clone.presentation.component.bottom_navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.lans.instagram_clone.R
import com.lans.instagram_clone.presentation.navigation.MainRoute
import com.lans.instagram_clone.utils.topBorder

@Composable
fun BottomNavigationBar(
    navigateToHome: () -> Unit,
    navigateToSearch: () -> Unit,
    navigateToLikes: () -> Unit,
    navigateToProfile: () -> Unit
) {
    BottomAppBar(
        modifier = Modifier
            .height(100.dp)
            .topBorder(0.2.dp, Color.LightGray),
        containerColor = Color.Transparent
    ) {
        var selectedItem by remember {
            mutableStateOf<MainRoute>(MainRoute.HomeScreen)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BottomNavigationItem().items().forEach { item ->
                IconButton(
                    onClick = {
                        when (item.route) {
                            is MainRoute.HomeScreen -> {
                                if(selectedItem != MainRoute.HomeScreen) {
                                    navigateToHome()
                                }
                            }
                            is MainRoute.SearchScreen -> {
                                if(selectedItem != MainRoute.SearchScreen) {
                                    navigateToSearch()
                                }
                            }
                            is MainRoute.LikesScreen -> {
                                if(selectedItem != MainRoute.LikesScreen) {
                                    navigateToLikes()
                                }
                            }
                            is MainRoute.ProfileScreen -> {
                                if(selectedItem != MainRoute.ProfileScreen) {
                                    navigateToProfile()
                                }
                            }
                        }
                        selectedItem = item.route
                    }
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            modifier = Modifier
                                .size(24.dp),
                            painter = if (item.route == selectedItem) {
                                painterResource(id = item.selectedIcon)
                            } else {
                                painterResource(id = item.unselectedIcon)
                            },
                            contentDescription = stringResource(R.string.content_description)
                        )
                    }
                }
            }
        }
    }
}