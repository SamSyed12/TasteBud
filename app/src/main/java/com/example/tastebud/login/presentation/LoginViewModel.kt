package com.example.tastebud.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tastebud.core.util.Resource
import com.example.tastebud.login.domain.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginScreenUiState())
    val uiState = _uiState.asStateFlow()

    fun signIn(
        username: String,
        password: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            setLoadingState(true)
            val response = userRepository.signIn(username = username, password = password)
            setLoadingState(false)
            setResponseState(response)
            when (_uiState.value.response.data) {
                true -> {
                    setLoginSuccessful(true)
                }
                false -> {
                    setShowMessage(true)
                }
                else -> {}
            }
        }
    }

    private fun setLoadingState(newLoadingState: Boolean) {
        _uiState.update {
            it.copy(isLoading = newLoadingState)
        }
    }

    private fun setResponseState(newResponseState: Resource<Boolean>) {
        _uiState.update {
            it.copy(response = newResponseState)
        }
    }

    fun setShowMessage(newShowMessageState: Boolean) {
        _uiState.update {
            it.copy(showMessage = newShowMessageState)
        }
    }

    private fun setLoginSuccessful(newLoginState: Boolean) {
        _uiState.update {
            it.copy( isLoginSuccessful = newLoginState)
        }
    }


}

