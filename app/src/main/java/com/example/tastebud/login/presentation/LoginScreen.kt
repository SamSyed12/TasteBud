package com.example.tastebud.login.presentation

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.tastebud.core.util.Resource

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun LoginScreen(
    viewModel: LoginViewModel,
    navigateToHome: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    LoginScreenUI(
        uiState = uiState,
        signIn = { username, password ->
            viewModel.signIn(username, password)
        },
        navigateToHome = navigateToHome
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenUI(
    uiState: LoginScreenUiState = LoginScreenUiState(),
    signIn: (username: String, password: String) -> Unit = {_,_ -> null },
    navigateToHome: () -> Unit = {}
) {
    var username by remember{
        mutableStateOf("")
    }
    var password by remember{
        mutableStateOf("")
    }
    val focusManager = LocalFocusManager.current
    val maxChar = 40
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable { focusManager.clearFocus() }
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        UsernameTextField(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(bottom = 10.dp),
            textValue = username,
            onTextChange = {
                username = it.take(maxChar)
                if (it.length > maxChar){
                    focusManager.moveFocus(FocusDirection.Down)
            }
            }
        )
        PasswordTextField(
            modifier = Modifier.fillMaxWidth(0.7f),
            textValue = password,
            onTextChange = {
                password = it.take(maxChar)
                if (it.length > maxChar){
                    focusManager.clearFocus(true)
                }
            },
            focusManager = focusManager
        )
        Button(
            onClick = { signIn(username, password)
                keyboardController?.hide()
                focusManager.clearFocus(true)
            },
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(0.7f),
            enabled = !uiState.isLoading
        ) {
            Text(text = "Login")
        }

    }
    if (uiState.isLoading) {
        CircularProgressIndicator()
    }
    when (uiState.response) {
        is Resource.Success -> {
            navigateToHome()
        }
        is Resource.Error -> {
            if (uiState.response.data == false) {
                Log.d("lol", "${uiState.response.data}")
                Toast.makeText(context, "${uiState.response.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}