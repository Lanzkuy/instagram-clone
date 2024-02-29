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
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.lans.instagram_clone.R
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
        var selectedItemIndex by rememberSaveable {
            mutableIntStateOf(0)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            BottomNavigationItem().items().forEachIndexed { index, item ->
                IconButton(
                    onClick = {
                        selectedItemIndex = index
                    }
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            modifier = Modifier
                                .size(24.dp),
                            painter = if (index == selectedItemIndex) {
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