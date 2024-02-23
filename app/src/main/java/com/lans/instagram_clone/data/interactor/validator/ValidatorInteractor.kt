package com.lans.instagram_clone.data.interactor.validator

import com.lans.instagram_clone.domain.usecase.validation.ValidateEmailUseCase
import com.lans.instagram_clone.domain.usecase.validation.ValidateFullnameUseCase
import com.lans.instagram_clone.domain.usecase.validation.ValidatePasswordUseCase
import com.lans.instagram_clone.domain.usecase.validation.ValidateUsernameUseCase
import com.lans.instagram_clone.domain.usecase.validation.ValidatorUseCase
import javax.inject.Inject

class ValidatorInteractor @Inject constructor(
    override val email: ValidateEmailUseCase,
    override val fullname: ValidateFullnameUseCase,
    override val username: ValidateUsernameUseCase,
    override val password: ValidatePasswordUseCase,
) : ValidatorUseCase