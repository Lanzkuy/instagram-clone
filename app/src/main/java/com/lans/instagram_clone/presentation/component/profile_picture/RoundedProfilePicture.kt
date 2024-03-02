package com.lans.instagram_clone.presentation.component.profile_picture

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.lans.instagram_clone.R

@Composable
fun RoundedProfilePicture(
    modifier: Modifier,
    imgUrl: String,
    active: Boolean = false
) {
    AsyncImage(
        modifier = modifier
            .clip(CircleShape)
            .border(
                width = 2.dp,
                brush = Brush.linearGradient(
                    colors = if (active) {
                        listOf(Color.Yellow, Color.Red)
                    } else {
                        listOf(Color.Gray, Color.LightGray)
                    },
                    start = Offset(0f, 0f),
                    end = Offset(70f, 70f)
                ),
                shape = CircleShape
            ),
        model = imgUrl,
        contentDescription = stringResource(R.string.content_description),
        contentScale = ContentScale.Crop
    )
}