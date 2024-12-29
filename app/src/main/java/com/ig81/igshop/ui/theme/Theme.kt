package com.ig81.igshop.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    background = BackgroundColor,
    primary = PrimaryColor,
    secondary = SecondaryColor,
    surface = SurfaceColor,
    tertiary = Pink80,
    onPrimary = OnPrimaryColor,
    onSecondary = OnSecondaryColor,
    onBackground = OnBackgroundColor,
    onSurface = OnSurfaceColor
)

private val LightColorScheme = lightColorScheme(
    background = BackgroundColor,
    primary = PrimaryColor,
    secondary = SecondaryColor,
    surface = SurfaceColor,
    tertiary = Pink40,
    onPrimary = OnPrimaryColor,
    onSecondary = OnSecondaryColor,
    onBackground = OnBackgroundColor,
    onSurface = OnSurfaceColor
)

val LocalIGShopColors = staticCompositionLocalOf<ColorScheme> {
    error("No colors provided")
}

val LocalIGShopTypography = staticCompositionLocalOf<Typography> {
    error("No font provided")
}

val LocalIGShopShape = staticCompositionLocalOf<JetIGShopShapes> {
    error("No shapes provided")
}

object IGShopTheme{
    val colorScheme: ColorScheme
        @Composable
        get() = LocalIGShopColors.current

    val typography: Typography
        @Composable
        get() = LocalIGShopTypography.current

    val shapes: JetIGShopShapes
        @Composable
        get() = LocalIGShopShape.current
}

@Composable
fun IGShopTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    CompositionLocalProvider(
        LocalIGShopColors provides colorScheme,
        LocalIGShopTypography provides typography,
        LocalIGShopShape provides shapes,
        content = content
    )
}