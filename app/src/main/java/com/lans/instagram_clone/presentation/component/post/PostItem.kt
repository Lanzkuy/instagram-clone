package com.lans.instagram_clone.presentation.component.post

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.lans.instagram_clone.R
import com.lans.instagram_clone.presentation.component.profile_picture.RoundedProfilePicture

@Composable
fun PostItem(
    profileImgUrl: String,
    profileUsername: String,
    postImgUrl: String,
    totalLikes: Int,
    postDescription: String,
    totalComments: Int,
    postDate: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 8.dp,
                bottom = 16.dp
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    bottom = 8.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundedProfilePicture(
                modifier = Modifier
                    .size(36.dp),
                imgUrl = profileImgUrl,
                active = false
            )
            Text(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(
                        start = 8.dp
                    )
                    .weight(1f),
                text = profileUsername,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            IconButton(
                onClick = {}
            ) {
                Icon(
                    modifier = Modifier
                        .size(14.dp),
                    painter = painterResource(R.drawable.ic_options),
                    contentDescription = stringResource(R.string.content_description),
                    tint = if (isSystemInDarkTheme()) {
                        Color.White
                    } else {
                        Color.DarkGray
                    }
                )
            }
        }
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth(),
            model = postImgUrl,
            contentDescription = stringResource(R.string.content_description),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .padding(
                    horizontal = 8.dp
                ),
            horizontalArrangement = Arrangement.spacedBy((-6).dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    modifier = Modifier
                        .size(26.dp),
                    painter = painterResource(R.drawable.ic_heart_deactive),
                    contentDescription = stringResource(R.string.content_description),
                    tint = if (isSystemInDarkTheme()) {
                        Color.White
                    } else {
                        Color.DarkGray
                    }
                )
            }
            IconButton(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(R.drawable.ic_comment),
                    contentDescription = stringResource(R.string.content_description),
                    tint = if (isSystemInDarkTheme()) {
                        Color.White
                    } else {
                        Color.DarkGray
                    }
                )
            }
            IconButton(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(R.drawable.ic_share),
                    contentDescription = stringResource(R.string.content_description),
                    tint = if (isSystemInDarkTheme()) {
                        Color.White
                    } else {
                        Color.DarkGray
                    }
                )
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            IconButton(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    modifier = Modifier
                        .size(24.dp),
                    painter = painterResource(R.drawable.ic_bookmark_deactive),
                    contentDescription = stringResource(R.string.content_description),
                    tint = if (isSystemInDarkTheme()) {
                        Color.White
                    } else {
                        Color.DarkGray
                    }
                )
            }
        }
        Text(
            modifier = Modifier
                .padding(
                    start = 20.dp
                ),
            text = "$totalLikes likes",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    top = 6.dp,
                    end = 20.dp
                ),
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(profileUsername)
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Normal
                    )
                ) {
                    append(" ")
                    append(postDescription)
                }
            },
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    top = 6.dp
                ),
            text = "View all $totalComments comments",
            color = Color.Gray,
            fontSize = 14.sp
        )
        Text(
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    top = 6.dp
                ),
            text = postDate,
            color = Color.Gray,
            fontSize = 12.sp
        )
    }
}