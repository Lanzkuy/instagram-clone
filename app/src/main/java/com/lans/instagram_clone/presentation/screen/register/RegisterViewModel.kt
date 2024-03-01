package com.lans.instagram_clone.presentation.screen.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lans.instagram_clone.data.Resource
import com.lans.instagram_clone.domain.model.User
import com.lans.instagram_clone.domain.usecase.CreateUserUseCase
import com.lans.instagram_clone.domain.usecase.RegisterUseCase
import com.lans.instagram_clone.domain.usecase.validation.ValidatorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    private val createUserUseCase: CreateUserUseCase,
    private val validatorUseCase: ValidatorUseCase
) : ViewModel() {

    private val _state = mutableStateOf(RegisterUIState())
    val state: State<RegisterUIState> get() = _state

    fun onEvent(event: RegisterUIEvent) {
        when (event) {
            is RegisterUIEvent.EmailChanged -> {
                _state.value = _state.value.copy(
                    email = _state.value.email.copy(
                        value = event.email
                    )
                )
            }

            is RegisterUIEvent.FullnameChanged -> {
                _state.value = _state.value.copy(
                    fullname = _state.value.fullname.copy(
                        value = event.fullname
                    )
                )
            }

            is RegisterUIEvent.UsernameChanged -> {
                _state.value = _state.value.copy(
                    username = _state.value.username.copy(
                        value = event.username
                    )
                )
            }

            is RegisterUIEvent.PasswordChanged -> {
                _state.value = _state.value.copy(
                    password = _state.value.password.copy(
                        value = event.password
                    )
                )
            }

            is RegisterUIEvent.RegisterButtonClicked -> {
                register()
            }
        }
    }

    fun register() {
        val stateValue = _state.value

        val emailResult = validatorUseCase.email.execute(stateValue.email.value)
        val fullnameResult = validatorUseCase.fullname.execute(stateValue.fullname.value)
        val usernameResult = validatorUseCase.username.execute(stateValue.username.value)
        val passwordResult = validatorUseCase.password.execute(stateValue.password.value)

        val hasErrors = listOf(
            emailResult,
            fullnameResult,
            usernameResult,
            passwordResult
        ).any { !it.isSuccess }

        if (hasErrors) {
            _state.value = stateValue.copy(
                email = stateValue.email.copy(
                    error = emailResult.errorMessage
                ),
                fullname = stateValue.fullname.copy(
                    error = fullnameResult.errorMessage
                ),
                username = stateValue.username.copy(
                    error = usernameResult.errorMessage
                ),
                password = stateValue.password.copy(
                    error = passwordResult.errorMessage
                )
            )
            return
        }

        viewModelScope.launch {
            registerUseCase.execute(
                email = stateValue.email.value,
                password = stateValue.password.value
            ).collect { response ->
                when (response) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            registerResponse = response.data,
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

    fun createUser(id: String) {
        val stateValue = _state.value

        viewModelScope.launch {
            createUserUseCase.execute(
                User(
                    id = id,
                    email = stateValue.email.value,
                    fullname = stateValue.fullname.value,
                    username = stateValue.username.value,
                    password = stateValue.password.value
                )
            ).collect { response ->
                when (response) {
                    is Resource.Success -> {
                        _state.value = _state.value.copy(
                            createUserResponse = response.data,
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