package com.lans.instagram_clone.domain.usecase

interface StoreUserCredentialsUseCase {
    suspend fun execute(userId: String)
}