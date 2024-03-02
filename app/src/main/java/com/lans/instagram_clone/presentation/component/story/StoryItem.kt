package com.lans.instagram_clone.presentation.component.story

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lans.instagram_clone.presentation.component.profile_picture.RoundedProfilePicture

@Composable
fun StoryItem(
    imgUrl: String,
    name: String,
    isSeen: Boolean = false
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        RoundedProfilePicture(
            modifier = Modifier
                .size(80.dp),
            imgUrl = imgUrl,
            active = isSeen
        )
        Text(
            text = name,
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp
        )
    }
}