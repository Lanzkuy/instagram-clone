package com.lans.instagram_clone.domain.model

data class InputWrapper<T>(
    var value: T,
    var error: String? = null
)
