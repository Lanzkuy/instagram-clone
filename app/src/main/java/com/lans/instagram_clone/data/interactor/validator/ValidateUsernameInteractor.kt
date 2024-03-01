package com.lans.instagram_clone.data.interactor.validator

import com.lans.instagram_clone.domain.model.ValidationResult
import com.lans.instagram_clone.domain.usecase.validation.ValidateUsernameUseCase

class ValidateUsernameInteractor : ValidateUsernameUseCase {
    override fun execute(input: String): ValidationResult {
        if (input.isBlank()) {
            return ValidationResult(
                isSuccess = false,
                errorMessage = "Username must be filled"
            )
        }

        if (input.length < 6) {
            return ValidationResult(
                isSuccess = false,
                errorMessage = "Username must be at least 6 characters long"
            )
        }

        return ValidationResult(
            isSuccess = true
        )
    }
}