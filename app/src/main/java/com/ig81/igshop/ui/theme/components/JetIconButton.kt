package com.ig81.igshop.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ig81.igshop.ui.theme.IGShopTheme

@Composable
fun JetIconButton(
    vectorDrawableId: Int,
    modifier: Modifier = Modifier,
    shape: CornerBasedShape = RoundedCornerShape(8.dp),
    contentPadding: PaddingValues = PaddingValues(12.dp),
    onClick: () -> Unit
) {
    val btnCoreColor = Color(0xFFA5A5A5)
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(btnCoreColor.copy(0.1f), shape)
            .clip(shape)
            .clickable(onClick = onClick)
            .padding(contentPadding)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = vectorDrawableId),
            tint = btnCoreColor,
            contentDescription = null,
            modifier = Modifier.sizeIn(24.dp, 24.dp)
        )
    }
}

@Preview(backgroundColor = 0xFF2E4552, showBackground = true)
@Composable
fun JetIconButtonPreview() {
    IGShopTheme {
        JetIconButton(
            vectorDrawableId = com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_chevron_left_16_filled,
            shape = RoundedCornerShape(8.dp),
            contentPadding = PaddingValues(12.dp),
            modifier = Modifier
        ) {
            println("Boop!")
        }
    }
}