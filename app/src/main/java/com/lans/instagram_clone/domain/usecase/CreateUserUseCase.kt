package com.lans.instagram_clone.domain.usecase

import com.lans.instagram_clone.data.Resource
import com.lans.instagram_clone.domain.model.User
import kotlinx.coroutines.flow.Flow

interface CreateUserUseCase {
    suspend fun execute(user: User): Flow<Resource<User>>
}