package com.lans.instagram_clone.domain.usecase

import com.google.firebase.auth.FirebaseUser
import com.lans.instagram_clone.data.Resource
import kotlinx.coroutines.flow.Flow

interface LoginWithEmailUseCase {
    suspend fun execute(email: String, password: String): Flow<Resource<FirebaseUser?>>
}