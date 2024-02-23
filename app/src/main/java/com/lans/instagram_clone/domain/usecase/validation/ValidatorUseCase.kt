package com.lans.instagram_clone.domain.usecase.validation

interface ValidatorUseCase {
    val email: ValidateEmailUseCase
    val fullname: ValidateFullnameUseCase
    val username: ValidateUsernameUseCase
    val password: ValidatePasswordUseCase
}