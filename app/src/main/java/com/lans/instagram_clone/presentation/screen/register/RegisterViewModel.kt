package com.lans.instagram_clone.presentation.screen.register

import androidx.lifecycle.ViewModel
import com.lans.instagram_clone.presentation.screen.login.LoginUIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(

) : ViewModel() {
    var state = MutableStateFlow(RegisterUIState())
        private set

    fun onEvent(event: RegisterUIEvent) {
        when (event) {
            is RegisterUIEvent.EmailChanged -> {

            }
            is RegisterUIEvent.FullnameChanged -> {

            }
            is RegisterUIEvent.UsernameChanged -> {

            }
            is RegisterUIEvent.PasswordChanged -> {

            }
            is RegisterUIEvent.RegisterButtonClicked -> {

            }
        }
    }
}