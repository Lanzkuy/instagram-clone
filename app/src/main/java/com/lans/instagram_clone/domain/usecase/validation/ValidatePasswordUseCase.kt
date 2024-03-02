package com.lans.instagram_clone.domain.usecase.validation

import com.lans.instagram_clone.domain.model.ValidationResult

interface ValidatePasswordUseCase {
    fun execute(input: String): ValidationResult
}