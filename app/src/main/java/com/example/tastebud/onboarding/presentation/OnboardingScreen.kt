package com.example.tastebud.onboarding.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tastebud.R

@Composable
fun OnboardingScreen(
    navigateToLogin: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background_green),
                contentScale = ContentScale.FillBounds
            )
    ) {

    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
private fun OnboardingScreenPreview() {
    OnboardingScreen(navigateToLogin = {})
}
