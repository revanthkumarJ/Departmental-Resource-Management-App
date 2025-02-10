package com.example.departmentalresourcemanagement.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF1976D2), // Blue
    secondary = Color(0xFFFFC107), // Amber
    background = Color(0xFFF5F5F5), // Light Gray
    surface = Color(0xFFFFFFFF), // White
    onPrimary = Color.White, // Text/Icon color on Primary (Button Text, etc.)
    onSecondary = Color.Black, // Text/Icon color on Secondary
    onBackground = Color(0xFF212121), // Dark Gray (Main Text)
    onSurface = Color(0xFF212121), // Text color on Surface
    error = Color(0xFFD32F2F) // Red (Error Messages)
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF90CAF9), // Light Blue
    secondary = Color(0xFFFFD54F), // Soft Yellow
    background = Color(0xFF121212), // Near Black
    surface = Color(0xFF1E1E1E), // Dark Gray
    onPrimary = Color.Black, // Text/Icon color on Primary
    onSecondary = Color.Black, // Text/Icon color on Secondary
    onBackground = Color(0xFFE0E0E0), // Light Gray (Main Text)
    onSurface = Color(0xFFE0E0E0), // Text color on Surface
    error = Color(0xFFFF6F61) // Light Red (Error Messages)
)


@Composable
fun DepartmentalResourceManagementTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}

