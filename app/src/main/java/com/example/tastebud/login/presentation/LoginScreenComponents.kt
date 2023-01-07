package com.example.tastebud.login.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun LoginTextField(
    modifier: Modifier = Modifier,
    textValue: String = "",
    label: String = "",
    onTextChange: (String) -> Unit = {}
) {
    OutlinedTextField(
        modifier = modifier,
        value = textValue,
        label = { Text(text = label) },
        onValueChange = onTextChange
    )
}
