package com.lans.instagram_clone.data.interactor.validator

import android.util.Patterns
import com.lans.instagram_clone.domain.model.ValidationResult
import com.lans.instagram_clone.domain.usecase.validation.ValidateEmailUseCase

class ValidateEmailInteractor : ValidateEmailUseCase {
    override fun execute(input: String): ValidationResult {
        if (input.isBlank()) {
            return ValidationResult(
                isSuccess = false,
                errorMessage = "Email must be filled"
            )
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(input).matches()) {
            return ValidationResult(
                isSuccess = false,
                errorMessage = "Email address is not valid"
            )
        }

        return ValidationResult(
            isSuccess = true
        )
    }
}