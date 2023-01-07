package com.example.tastebud.login.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen() {

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

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LoginTextField(
                modifier = Modifier.padding(10.dp),
                textValue = username,
                label = "Email",
                onTextChange = {
                    username = it
                }
            )
            LoginTextField(
                textValue = password,
                label = "Password",
                onTextChange = {
                    password = it
                }
            )
        }
    }
}