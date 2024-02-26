package com.lans.instagram_clone.presentation.screen.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.lans.instagram_clone.presentation.component.BottomNavigationBar
import com.lans.instagram_clone.presentation.component.HomeAppBar
import com.lans.instagram_clone.presentation.component.MyStory
import com.lans.instagram_clone.presentation.component.PostItem
import com.lans.instagram_clone.presentation.component.StoryItem
import com.lans.instagram_clone.utils.bottomBorder

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val img1 =
        "https://yt3.googleusercontent.com/ytc/AIf8zZTiK5RvLXMDN039g8slQDcm--od1i1y6wwxqzF45g=s900-c-k-c0x00ffffff-no-rj"
    val img2 =
        "https://i.pinimg.com/736x/06/11/c1/0611c18c40bd413039b0899ccf5b0108.jpg"
    val squirrel =
        "https://nypost.com/wp-content/uploads/sites/2/2020/10/squirrel1.jpeg?quality=75&strip=all"

    Scaffold(
        topBar = { HomeAppBar() },
        bottomBar = { BottomNavigationBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .bottomBorder(0.5.dp, Color.LightGray)
                    .padding(
                        top = 6.dp,
                        bottom = 16.dp
                    )
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                MyStory(
                    modifier = Modifier.padding(
                        start = 20.dp
                    ),
                    imgUrl = img1
                )
                StoryItem(
                    imgUrl = img2,
                    name = "Risdu"
                )
                StoryItem(
                    imgUrl = img2,
                    name = "Risdu"
                )
                StoryItem(
                    imgUrl = img2,
                    name = "Risdu"
                )
                StoryItem(
                    imgUrl = img2,
                    name = "Risdu"
                )
                StoryItem(
                    imgUrl = img2,
                    name = "Risdu"
                )
                StoryItem(
                    imgUrl = img2,
                    name = "Risdu"
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                PostItem(
                    profileImgUrl = img2,
                    profileUsername = "Risdu",
                    postImgUrl = squirrel,
                    totalLikes = 1423,
                    postDescription = "Just a squirrel bring a lot of nuts",
                    totalComments = 108,
                    postDate = "28 November 2023"
                )
                PostItem(
                    profileImgUrl = img2,
                    profileUsername = "Risdu",
                    postImgUrl = squirrel,
                    totalLikes = 1423,
                    postDescription = "Just a squirrel bring a lot of nuts",
                    totalComments = 108,
                    postDate = "28 November 2023"
                )
                PostItem(
                    profileImgUrl = img2,
                    profileUsername = "Risdu",
                    postImgUrl = squirrel,
                    totalLikes = 1423,
                    postDescription = "Just a squirrel bring a lot of nuts",
                    totalComments = 108,
                    postDate = "28 November 2023"
                )
            }
        }
    }
}