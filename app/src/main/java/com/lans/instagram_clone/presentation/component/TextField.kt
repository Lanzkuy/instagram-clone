package com.lans.instagram_clone.presentation.component

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.lans.instagram_clone.domain.model.InputWrapper

@Composable
fun ValidableTextField(
    modifier: Modifier,
    input: InputWrapper,
    isPassword: Boolean = false,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = remember {
        KeyboardOptions.Default
    },
    onValueChange: (value: String) -> Unit
) {
    var passwordVisible by rememberSaveable { mutableStateOf(true) }

    OutlinedTextField(
        modifier = modifier,
        value = input.value,
        label = { if (label != null) Text(label) },
        placeholder = { if (placeholder != null) Text(placeholder) },
        supportingText = { if (input.error != null) Text(input.error!!) },
        isError = input.error != null,
        singleLine = true,
        leadingIcon = leadingIcon,
        trailingIcon = if (trailingIcon == null && isPassword) {
            {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password"
                    )
                }
            }
        } else trailingIcon,
        keyboardOptions = keyboardOptions,
        visualTransformation = if (passwordVisible && isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        onValueChange = onValueChange
    )

}