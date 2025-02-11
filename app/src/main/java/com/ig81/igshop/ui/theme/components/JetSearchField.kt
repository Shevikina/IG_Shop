package com.ig81.igshop.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.ui.theme.IGShopTheme

@Composable
fun JetSearchField(
    hint: String,
    value: String = "",
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .shadow(
                4.dp,
                ambientColor = Color.Black.copy(0.02f)
            )
            .background(
                IGShopTheme.colorScheme.surface,
                IGShopTheme.shapes.small
            )
            .padding(11.dp)
    ) {
        Icon(
            painter = painterResource(id = com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_search_48_regular),
            tint = IGShopTheme.colorScheme.tertiary,
            modifier = Modifier.size(24.dp),
            contentDescription = null
        )
        Spacer(Modifier.width(17.dp))
        Text(
            text = if (value.isEmpty()) hint else value,
            style = IGShopTheme.typography.bodyLarge.copy(
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = IGShopTheme.colorScheme.onSurface
                )
        )
    }
}

@Preview
@Composable
private fun JetSearchFieldPreview() {
    IGShopTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(IGShopTheme.colorScheme.background)
                .padding(32.dp)
        ) {
            JetSearchField(
                hint = "Найти спорткар ...",
                "",
                Modifier.width(250.dp)
            )
        }
    }
}
