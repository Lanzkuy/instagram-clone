package com.lans.instagram_clone.presentation.screen.login

sealed class LoginUIEvent {
    data class EmailUsernameChanged(val emailUsername: String): LoginUIEvent()
    data class PasswordChanged(val password: String): LoginUIEvent()
    object LoginButtonClicked: LoginUIEvent()
}
