package com.lans.instagram_clone.presentation.component.story

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.lans.instagram_clone.R

@Composable
fun MyStory(
    modifier: Modifier,
    imgUrl: String
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .clickable { }
        ) {
            AsyncImage(
                modifier = Modifier
                    .clip(CircleShape),
                model = imgUrl,
                contentDescription = stringResource(R.string.content_description),
                contentScale = ContentScale.Crop,
            )
            Icon(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    )
                    .border(
                        border = BorderStroke(2.dp, Color.Blue),
                        shape = CircleShape
                    ),
                imageVector = Icons.Default.AddCircle,
                contentDescription = stringResource(R.string.content_description),
                tint = Color.Blue,
            )
        }
        Text(
            text = stringResource(R.string.your_story),
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp
        )
    }
}