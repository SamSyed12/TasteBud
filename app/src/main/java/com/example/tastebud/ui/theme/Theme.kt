package com.example.tastebud.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * @param primary
 * @param secondary
 * @param tertiary icon colors
 */
private val DarkColorPalette = darkColorScheme(
    primary = Purple200,
    secondary = Teal200,
    tertiary = Color(0xFFFFFFFF)
)

/**
 * @param primary
 * @param secondary
 * @param tertiary icon colors
 */
private val LightColorPalette = lightColorScheme(
    primary = Purple500,
    secondary = Teal200,
    tertiary = Color(0xFFFFFFFF)
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun TasteBudTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}