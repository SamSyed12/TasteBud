package com.example.tastebud.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastebud.core.util.Resource
import com.example.tastebud.login.data.UserRepositoryImpl
import com.example.tastebud.login.data.UserRepositoryProvider
import com.example.tastebud.login.domain.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    private val userRepository: UserRepository = UserRepositoryProvider.userRepository
    private val _uiState = MutableStateFlow(LoginScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun signIn(
        username: String,
        password: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(isLoading = true) }
            val response = userRepository.signIn(username = username, password = password)
            _uiState.update {
                it.copy(
                    isLoading = false,
                    response = response,
                )
            }
            delay(50)
            _uiState.update { it.copy(response = Resource.Error(data = null, message = "")) }
        }
    }
}

