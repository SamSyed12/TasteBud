package com.example.tastebud.login.presentation

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.tastebud.ui.theme.Purple700

@Preview
@Composable
fun UsernameTextField(
    textValue: String = "",
    onTextChange: (String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        modifier = modifier,
        value = textValue,
        label = { Text(text = "Email") },
        onValueChange = onTextChange,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Red,
            unfocusedBorderColor = Purple700
        ),
        singleLine = true,
    )
}
@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    textValue: String = "",
    onTextChange: (String) -> Unit = {},
    focusManager: FocusManager
){
    var showPassword by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        modifier = modifier,
        value = textValue,
        label = { Text(text = "Password") },
        onValueChange = onTextChange,
        singleLine = true,
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        ),
        visualTransformation = if (showPassword) VisualTransformation.None
            else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = {showPassword = !showPassword }) {
                Icon(
                    imageVector = if (showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                    contentDescription = "Visibility",
                )
            }
        }
    )
}







