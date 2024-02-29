package com.lans.instagram_clone.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.lans.instagram_clone.common.CONSTANTS.USER_COLLECTION
import com.lans.instagram_clone.domain.repository.IAuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : IAuthRepository {
    override suspend fun isAuthenticated(): Flow<Boolean> {
        return flow {
            emit(firebaseAuth.currentUser != null)
        }
    }

    override suspend fun loginWithEmail(email: String, password: String): Task<AuthResult> {
        return firebaseAuth.signInWithEmailAndPassword(email, password)
    }

    override suspend fun register(email: String, password: String): Task<AuthResult> {
        return firebaseAuth.createUserWithEmailAndPassword(email, password)
    }

    override suspend fun logout(): Flow<Unit> {
        return flow {
            emit(firebaseAuth.signOut())
        }
    }
}