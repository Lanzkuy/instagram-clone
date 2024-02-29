package com.lans.instagram_clone.domain.repository

import kotlinx.coroutines.flow.Flow

interface IDataStoreRepository {
    suspend fun getUserId(): Flow<String>
    suspend fun storeUserId(userId: String): Flow<Unit>
    suspend fun clear(): Flow<Unit>
}