package com.lans.instagram_clone.data.interactor.validator

import com.lans.instagram_clone.domain.model.ValidationResult
import com.lans.instagram_clone.domain.usecase.validation.ValidateFullnameUseCase

class ValidateFullnameInteractor : ValidateFullnameUseCase {
    override fun execute(input: String): ValidationResult {
        if (input.isBlank()) {
            return ValidationResult(
                isSuccess = false,
                errorMessage = "Fullname must be filled"
            )
        }

        if (input.length < 4) {
            return ValidationResult(
                isSuccess = false,
                errorMessage = "Fullname must be at least 4 characters long"
            )
        }

        return ValidationResult(
            isSuccess = true
        )
    }
}