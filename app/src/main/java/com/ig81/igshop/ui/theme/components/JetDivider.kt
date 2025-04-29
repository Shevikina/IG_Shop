package com.ig81.igshop.ui.theme.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ig81.igshop.ui.theme.IGShopTheme

@Composable
fun JetDivider(paddingValues: PaddingValues = PaddingValues(vertical = 8.dp)) = HorizontalDivider(
    modifier = Modifier.padding(paddingValues),
    thickness = 2.dp,
    color = IGShopTheme.colorScheme.tertiary.copy(0.25f)
)