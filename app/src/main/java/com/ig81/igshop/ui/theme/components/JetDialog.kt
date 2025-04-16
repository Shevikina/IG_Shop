package com.ig81.igshop.ui.theme.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.utils.advancedShadow
import com.microsoft.fluent.mobile.icons.R

@Composable
fun JetDialog(
    title: String = "Ошибка",
    body: String = "Проверьте ...",
    buttonText: String = "ОК",
    icon: Int = R.drawable.ic_fluent_wifi_off_24_regular,
    onClose: () -> Unit
) {
    val shapeRadius = 24.dp

    Box(Modifier.width(381.dp))
    {
        Box(
            Modifier
                .align(Alignment.TopCenter)
                .size(81.dp)
                .advancedShadow(
                    alpha = 0.1f,
                    offsetY = 4.dp,
                    shadowBlurRadius = 4.dp,
                    cornersRadius = 41.dp
                )
                .background(
                    IGShopTheme.colorScheme.background,
                    CircleShape
                )
        )

        Column(
            Modifier
                .padding(top = 41.dp)
                .advancedShadow(
                    alpha = 0.1f,
                    offsetY = 4.dp,
                    shadowBlurRadius = 4.dp,
                    cornersRadius = shapeRadius
                )
                .background(
                    color = IGShopTheme.colorScheme.background,
                    shape = IGShopTheme.shapes.dialog
                )
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 29.dp)
            ) {
                Text(
                    text = title,
                    style = IGShopTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        color = IGShopTheme.colorScheme.tertiary
                    )
                )
                Text(
                    text = body,
                    style = IGShopTheme.typography.bodyLarge.copy(
                        fontSize = 14.sp,
                        color = IGShopTheme.colorScheme.tertiary,
                        textAlign = TextAlign.Center,
                        letterSpacing = 0.em,
                    )
                )
            }
            Button(
                onClick = onClose,
                shape = RoundedCornerShape(bottomStart = shapeRadius, bottomEnd = shapeRadius),
                colors = ButtonDefaults.textButtonColors(
                    contentColor = IGShopTheme.colorScheme.background,
                    containerColor = IGShopTheme.colorScheme.primary
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 48.dp)
            ) {
                Text(
                    text = buttonText,
                    style = IGShopTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.em,
                    )
                )
            }
        }

        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Error Info Icon",
            tint = IGShopTheme.colorScheme.primary,
            modifier = Modifier
                .padding(top = 14.dp)
                .size(42.dp)
                .align(Alignment.TopCenter)
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun JetDialogPreview() {
    IGShopTheme {
        JetDialog(
            title = "Ошибка",
            body = "Проверьте подключение к сети Интернет",
            buttonText = "ОК",
            icon = R.drawable.ic_fluent_wifi_off_24_regular,
            onClose = { Log.i("My", "Close") }
        )
    }
}