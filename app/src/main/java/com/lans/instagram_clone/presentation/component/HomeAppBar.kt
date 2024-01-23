package com.lans.instagram_clone.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.lans.instagram_clone.R


@Composable
fun HomeAppBar() {
    TopAppBar(
        title = {
            Image(
                modifier = Modifier
                    .size(132.dp),
                painter = if (isSystemInDarkTheme()) {
                    painterResource(R.drawable.img_instagram_text_white)
                } else {
                    painterResource(R.drawable.img_instagram_text_black)
                },
                contentDescription = stringResource(R.string.content_description)
            )
        },
        actions = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    modifier = Modifier.size(28.dp),
                    painter = if (isSystemInDarkTheme()) {
                        painterResource(R.drawable.ic_message_white)
                    } else {
                        painterResource(R.drawable.ic_message_black)
                    },
                    contentDescription = stringResource(R.string.content_description)
                )
            }
        }
    )
}