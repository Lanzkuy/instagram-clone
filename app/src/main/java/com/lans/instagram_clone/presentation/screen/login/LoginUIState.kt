package com.lans.instagram_clone.presentation.screen.login

import com.lans.instagram_clone.domain.model.InputWrapper

data class LoginUIState(
    var emailUsername: InputWrapper<String> = InputWrapper(""),
    var password: InputWrapper<String> = InputWrapper("")
)
