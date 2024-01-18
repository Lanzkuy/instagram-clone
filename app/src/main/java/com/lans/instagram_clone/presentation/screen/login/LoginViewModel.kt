package com.lans.instagram_clone.presentation.screen.login

import androidx.lifecycle.ViewModel
import com.lans.instagram_clone.domain.model.InputWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

) : ViewModel() {
    var state = MutableStateFlow(LoginUIState())
        private set

    fun onEvent(event: LoginUIEvent) {
        when (event) {
            is LoginUIEvent.EmailUsernameChanged -> {

            }
            is LoginUIEvent.PasswordChanged -> {

            }
            is LoginUIEvent.LoginButtonClicked -> {

            }
        }
    }
}