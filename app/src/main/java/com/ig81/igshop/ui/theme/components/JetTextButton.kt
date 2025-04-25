package com.ig81.igshop.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.ig81.igshop.ui.theme.IGShopTheme

@Composable
fun JetTextButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val shape = IGShopTheme.shapes.dialog
    TextButton(
        onClick = onClick,
        modifier = modifier
            .background(
                color = IGShopTheme.colorScheme.primary,
                shape = shape
            )
            .border(4.dp, Color.Black.copy(0.25f), shape)
            .clip(shape)
            .heightIn(min = 54.dp)
            .padding(vertical = 3.dp)
    ) {
        Text(
            text = text,
            color = Color.Black.copy(0.5f),
            style = IGShopTheme.typography.bodyLarge.copy(
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                lineHeight = 1.em,
                letterSpacing = 0.em
            )
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF2E4552)
@Composable
private fun JetTextButtonPreview() {
    IGShopTheme {
        JetTextButton(
            text = "Отправить заявку",
            modifier = Modifier.fillMaxWidth(),
            onClick = {}
        )
    }
}