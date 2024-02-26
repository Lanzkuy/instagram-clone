package com.lans.instagram_clone.presentation.screen.register

import com.google.firebase.auth.FirebaseUser
import com.lans.instagram_clone.domain.model.InputWrapper
import com.lans.instagram_clone.domain.model.User

data class RegisterUIState(
    var email: InputWrapper = InputWrapper(),
    var fullname: InputWrapper = InputWrapper(),
    var username: InputWrapper = InputWrapper(),
    var password: InputWrapper = InputWrapper(),
    var isLoading: Boolean = false,
    var error: String = "",
    var registerResponse: FirebaseUser? = null,
    var createUserResponse: User? = null
)
