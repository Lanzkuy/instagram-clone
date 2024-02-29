package com.lans.instagram_clone.data.interactor

import com.lans.instagram_clone.data.Resource
import com.lans.instagram_clone.domain.repository.IAuthRepository
import com.lans.instagram_clone.domain.usecase.IsAuthenticatedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class IsAuthenticatedInteractor @Inject constructor(
    private val authRepository: IAuthRepository
) : IsAuthenticatedUseCase {
    override suspend fun execute(): Flow<Resource<Boolean>> {
        return flow {
            emit(Resource.Loading)
            try {
                val isAuthenticated = authRepository.isAuthenticated().first()
                emit(Resource.Success(isAuthenticated))
            } catch (exception: Exception) {
                emit(
                    Resource.Error(
                        exception.localizedMessage?.toString() ?: "Something went wrong"
                    )
                )
            }
        }.flowOn(Dispatchers.IO)
    }
}