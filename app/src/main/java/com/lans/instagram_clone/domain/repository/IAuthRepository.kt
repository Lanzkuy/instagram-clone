package com.lans.instagram_clone.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Query
import kotlinx.coroutines.flow.Flow

interface IAuthRepository {
    fun isAuthenticated(): Flow<Boolean>
    fun loginWithEmail(email: String, password: String): Task<AuthResult>
    fun register(email: String, password: String): Task<AuthResult>
    fun logout(): Flow<Unit>
}