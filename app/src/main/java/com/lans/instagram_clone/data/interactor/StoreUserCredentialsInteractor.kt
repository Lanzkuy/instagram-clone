package com.lans.instagram_clone.data.interactor

import com.lans.instagram_clone.domain.repository.IDataStoreRepository
import com.lans.instagram_clone.domain.usecase.StoreUserCredentialsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class StoreUserCredentialsInteractor @Inject constructor(
    private val datastoreRepository: IDataStoreRepository
) : StoreUserCredentialsUseCase {
    override suspend fun execute(userId: String) {
        datastoreRepository.storeUserId(userId).flowOn(Dispatchers.IO)
    }
}