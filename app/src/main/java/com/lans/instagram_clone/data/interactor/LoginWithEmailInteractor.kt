package com.lans.instagram_clone.data.interactor

import com.google.firebase.auth.FirebaseUser
import com.lans.instagram_clone.data.Resource
import com.lans.instagram_clone.domain.repository.IAuthRepository
import com.lans.instagram_clone.domain.usecase.LoginWithEmailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class LoginWithEmailInteractor @Inject constructor(
    private val authRepository: IAuthRepository
) : LoginWithEmailUseCase {
    override suspend fun execute(email: String, password: String): Flow<Resource<FirebaseUser?>> {
        return callbackFlow {
            trySend(Resource.Loading)
            authRepository.loginWithEmail(
                email = email,
                password = password
            ).addOnCompleteListener { task ->
                trySend(
                    if (task.isSuccessful) {
                        Resource.Success(task.result.user)
                    } else {
                        Resource.Error(task.exception?.localizedMessage ?: "Something went wrong")
                    }
                )
            }
            awaitClose()
        }.flowOn(Dispatchers.IO)
    }
}