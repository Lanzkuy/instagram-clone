package com.lans.instagram_clone.presentation.screen.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lans.instagram_clone.data.Resource
import com.lans.instagram_clone.domain.usecase.LoginWithEmailUseCase
import com.lans.instagram_clone.domain.usecase.validation.ValidatorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginWithEmailUseCase: LoginWithEmailUseCase,
    private val validatorUseCase: ValidatorUseCase
) : ViewModel() {

    private val _state = mutableStateOf(LoginUIState())
    val state: State<LoginUIState> get() = _state

    fun onEvent(event: LoginUIEvent) {
        when (event) {
            is LoginUIEvent.EmailUsernameChanged -> {
                _state.value = _state.value.copy(
                    emailUsername = _state.value.emailUsername.copy(
                        value = event.emailUsername
                    )
                )
            }

            is LoginUIEvent.PasswordChanged -> {
                _state.value = _state.value.copy(
                    password = _state.value.password.copy(
                        value = event.password
                    )
                )
            }

            is LoginUIEvent.LoginButtonClicked -> {
                login()
            }
        }
    }

    fun login() {
        var stateValue = _state.value

        val emailOrUsernameResult = validatorUseCase.email.invoke(stateValue.emailUsername.value)
        val passwordResult = validatorUseCase.password.invoke(stateValue.password.value)

        val hasErrors = listOf(
            emailOrUsernameResult,
            passwordResult
        ).any() { !it.isSuccess }

        if (hasErrors) {
            _state.value = stateValue.copy(
                emailUsername = stateValue.emailUsername.copy(
                    error = emailOrUsernameResult.errorMessage
                ),
                password = stateValue.password.copy(
                    error = passwordResult.errorMessage
                )
            )
            return
        }

        viewModelScope.launch {
            loginWithEmailUseCase.execute(
                email = stateValue.emailUsername.value,
                password = stateValue.password.value
            ).collect { response ->
                when (response) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            loginResponse = response.data,
                            isLoading = false
                        )
                    }

                    is Resource.Error -> {
                        _state.value = _state.value.copy(
                            error = response.message,
                            isLoading = false
                        )
                    }

                    is Resource.Loading -> {
                        _state.value = _state.value.copy(
                            isLoading = true
                        )
                    }

                    else -> Unit
                }
            }
        }
    }
}