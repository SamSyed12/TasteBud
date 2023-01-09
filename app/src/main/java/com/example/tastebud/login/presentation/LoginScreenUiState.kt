package com.example.tastebud.login.presentation

import com.example.tastebud.login.domain.LoadingStatus
import com.example.tastebud.login.domain.FirebaseApiResult
import com.example.tastebud.util.Resource

data class LoginScreenUiState(
    val isLoading: LoadingStatus = LoadingStatus.IDLE,
    val resource: Resource<FirebaseApiResult> = Resource.Success(data = null)
)
