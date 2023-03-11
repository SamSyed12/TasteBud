package com.example.tastebud.onboarding.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(104.dp))
            Icon(
                modifier = Modifier
                    .size(79.dp)
                    .padding(bottom = 14.dp),
                painter = painterResource(id = R.drawable.ic_chef_hat),
                contentDescription = "Chef Hat",
                tint = MaterialTheme.colorScheme.tertiary
            )
            Text(
                text = stringResource(id = R.string.taste_bud_title),
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.tertiary
            )
            Spacer(modifier = Modifier.height(222.dp))
            Text(
                text = stringResource(id = R.string.get_started),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.tertiary
            )
            Text(
                text = stringResource(id = R.string.prompt_message),
                style = MaterialTheme.typography.displayMedium,
                color = MaterialTheme.colorScheme.tertiary
            )
            Spacer(modifier = Modifier.height(64.dp))
            Button(
                modifier = Modifier
                    .width(243.dp)
                    .height(54.dp),
                shape = RoundedCornerShape(percent = 10),
                onClick = navigateToLogin
            ) {

            }
        }
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
