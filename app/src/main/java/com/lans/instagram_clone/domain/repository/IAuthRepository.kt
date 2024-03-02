package com.lans.instagram_clone.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Query
import kotlinx.coroutines.flow.Flow

interface IAuthRepository {
    suspend fun isAuthenticated(): Flow<Boolean>
    suspend fun loginWithEmail(email: String, password: String): Task<AuthResult>
    suspend fun register(email: String, password: String): Task<AuthResult>
    suspend fun logout()
}