package com.ig81.igshop.ui.screens.achievements.views.components

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ig81.igshop.ui.theme.IGShopTheme


@Composable
fun TabTitleButton(text: String, colorSwitcher: () -> Boolean, onClick: () -> Unit) {
    val selectedTextColors = ButtonDefaults.textButtonColors(
        containerColor = IGShopTheme.colorScheme.secondary.copy(0.1f),
        contentColor = IGShopTheme.colorScheme.secondary
    )
    val unselectedTextColors = ButtonDefaults.textButtonColors(
        containerColor = Color.Transparent,
        contentColor = Color(0xFFABB2BC)
    )

    TextButton(
        onClick = onClick,
        colors = if (colorSwitcher.invoke()) selectedTextColors else unselectedTextColors
    ) {
        Text(
            text = text,
            style = IGShopTheme.typography.bodyLarge.copy(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        )
    }
}