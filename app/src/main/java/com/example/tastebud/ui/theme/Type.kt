package com.example.tastebud.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tastebud.R


val poppinsFontFamily = FontFamily(
    Font(R.font.poppins_light)
)

val appTypography = Typography(
    displayMedium = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.W600,
        fontFamily = poppinsFontFamily
    ),
    displayLarge = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.W600,
        fontFamily = poppinsFontFamily
    ),
    headlineMedium = TextStyle(
        fontSize = 50.sp,
        fontWeight = FontWeight.W600,
        fontFamily = poppinsFontFamily
    )
)

// Set of Material typography styles to start with
val Typography = appTypography
