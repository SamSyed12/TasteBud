package com.example.tastebud.login.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tastebud.R
import com.example.tastebud.ui.theme.Purple700


@Preview
@Composable
fun UsernameTextField(
    textValue: String = "",
    onTextChange: (String) -> Unit = {}
) {
    OutlinedTextField(
        modifier = Modifier
            .padding(10.dp),
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
    textValue: String = "",
    onTextChange: (String) -> Unit = {},
    focusManager: FocusManager
){
    var showPassword by remember {
        mutableStateOf(false)
    }
    OutlinedTextField(
        value = textValue,
        label = { Text(text = "Password") },
        onValueChange = onTextChange,
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Red,
            unfocusedBorderColor = Purple700
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
            }
        ),
        visualTransformation = if (showPassword) VisualTransformation.None
            else PasswordVisualTransformation(),
        trailingIcon = {
            val icon = if (showPassword) {
                painterResource(id = R.drawable.ic_baseline_visibility_24)
            } else {
                painterResource(id = R.drawable.ic_baseline_visibility_off_24)
            }

            IconButton(onClick = {showPassword = !showPassword }) {
                Icon(
                    painter = icon,
                    contentDescription = "Visibility Toggle",
                )
            }
        }

    )
}





