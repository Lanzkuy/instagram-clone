package com.lans.instagram_clone.domain.model

data class User(
    val id: String = "",
    val email: String = "",
    val fullname: String = "",
    val username: String = "",
    val password: String = "",
    val imgUrl: String = "",
    val bio: String = "",
    val following: List<String> = emptyList(),
    val follower: List<String> = emptyList(),
    val totalPosts: String = ""
)
