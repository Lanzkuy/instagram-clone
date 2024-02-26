package com.lans.instagram_clone.presentation.screen.register

sealed class RegisterUIEvent {
    data class EmailChanged(val email: String) : RegisterUIEvent()
    data class FullnameChanged(val fullname: String) : RegisterUIEvent()
    data class UsernameChanged(val username: String) : RegisterUIEvent()
    data class PasswordChanged(val password: String) : RegisterUIEvent()
    object RegisterButtonClicked : RegisterUIEvent()
}
