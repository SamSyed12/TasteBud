package com.example.tastebud.login.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen() {
    LoginScreenUI()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenUI() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        var username by remember{
            mutableStateOf("")
        }
        var password by remember{
            mutableStateOf("")
        }
        val focusManager = LocalFocusManager.current
        val maxChar = 40

        Column(
            modifier = Modifier
                .fillMaxSize()
                .clickable { focusManager.clearFocus() },
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
            Button(onClick = {  }) {

            }
        }
    }
}