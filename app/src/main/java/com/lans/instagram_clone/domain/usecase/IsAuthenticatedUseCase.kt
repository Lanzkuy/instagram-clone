package com.lans.instagram_clone.domain.usecase

import com.lans.instagram_clone.data.Resource
import kotlinx.coroutines.flow.Flow

interface IsAuthenticatedUseCase {
    suspend fun execute(): Flow<Resource<Boolean>>
}