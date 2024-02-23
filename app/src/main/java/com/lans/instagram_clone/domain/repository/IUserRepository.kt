package com.lans.instagram_clone.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.lans.instagram_clone.domain.model.User
import kotlinx.coroutines.flow.Flow

interface IUserRepository {
    fun createUser(user: User): Task<Void>
    fun getUser(userId: String): Task<DocumentSnapshot>
}