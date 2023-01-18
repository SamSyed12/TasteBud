package com.example.tastebud.login.presentation

import com.example.tastebud.core.util.Resource

data class LoginScreenUiState(
    val isLoading: Boolean = false,
    val response: Resource<Boolean> = Resource.Error(data = null, message = ""),
)

