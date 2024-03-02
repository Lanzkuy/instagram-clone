package com.lans.instagram_clone.data.interactor

import com.lans.instagram_clone.data.Resource
import com.lans.instagram_clone.domain.model.User
import com.lans.instagram_clone.domain.repository.IUserRepository
import com.lans.instagram_clone.domain.usecase.CreateUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CreateUserInteractor @Inject constructor(
    private val userRepository: IUserRepository
) : CreateUserUseCase {
    override suspend fun execute(user: User): Flow<Resource<User>> {
        return callbackFlow {
            trySend(Resource.Loading)
            userRepository.createUser(
                user = user
            ).addOnCompleteListener { task ->
                trySend(
                    if (task.isSuccessful) {
                        Resource.Success(user)
                    } else {
                        Resource.Error(task.exception?.localizedMessage ?: "Something went wrong")
                    }
                )
            }
            awaitClose()
        }.flowOn(Dispatchers.IO)
    }
}