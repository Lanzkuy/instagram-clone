package com.lans.instagram_clone.data.repository

import com.lans.instagram_clone.data.source.local.DataStoreManager
import com.lans.instagram_clone.data.source.local.DataStoreManager.Companion.USER_ID
import com.lans.instagram_clone.domain.repository.IDataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DataStoreRepository @Inject constructor(
    private val dataStoreManager: DataStoreManager
) : IDataStoreRepository {
    override suspend fun getUserId(): Flow<String> {
        return dataStoreManager.userId
    }

    override suspend fun storeUserId(userId: String): Flow<Unit> {
        return flow {
            emit(dataStoreManager.storeData(USER_ID, userId))
        }
    }

    override suspend fun clear() {
        dataStoreManager.clear()
    }
}