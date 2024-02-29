package com.lans.instagram_clone.presentation.screen.login

import com.google.firebase.auth.FirebaseUser
import com.lans.instagram_clone.domain.model.InputWrapper
import com.lans.instagram_clone.domain.model.User

data class LoginUIState(
    var emailUsername: InputWrapper = InputWrapper(),
    var password: InputWrapper = InputWrapper(),
    var isLoading: Boolean = false,
    var error: String = "",
    var loginResponse: FirebaseUser? = null
)
