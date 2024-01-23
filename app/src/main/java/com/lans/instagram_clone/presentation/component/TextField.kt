package com.lans.instagram_clone.presentation.component

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.lans.instagram_clone.domain.model.InputWrapper

@Composable
fun ValidableTextField(
    modifier: Modifier,
    input: InputWrapper<String>,
    label: String? = null,
    placeholder: String? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = remember {
        KeyboardOptions.Default
    },
    onValueChange: (value: String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = input.value,
        label = {
            if (label != null) {
                Text(label)
            }
        },
        placeholder = {
            if (placeholder != null) {
                Text(placeholder)
            }
        },
        supportingText = {
            if (input.error != null) {
                Text(input.error!!)
            }
        },
        isError = input.error != null,
        singleLine = true,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardOptions = keyboardOptions,
        onValueChange = onValueChange
    )
}