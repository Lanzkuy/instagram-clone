package com.lans.instagram_clone.presentation.screen.register

import com.lans.instagram_clone.domain.model.InputWrapper

data class RegisterUIState(
    var email: InputWrapper<String> = InputWrapper(""),
    var fullname: InputWrapper<String> = InputWrapper(""),
    var username: InputWrapper<String> = InputWrapper(""),
    var password: InputWrapper<String> = InputWrapper("")
)
