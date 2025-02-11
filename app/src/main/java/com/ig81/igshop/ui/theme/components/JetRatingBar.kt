package com.ig81.igshop.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.ig81.igshop.ui.theme.IGShopTheme
import com.microsoft.fluent.mobile.icons.R

@Composable
fun JetStar(color: Color, modifier: Modifier = Modifier) {
    Icon(
        painter = painterResource(id = R.drawable.ic_fluent_star_16_filled),
        tint = color,
        contentDescription = "Icon with star",
        modifier = modifier
    )
}

@Composable
fun JetRatingBar(rating: Int, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        repeat(rating) { JetStar(IGShopTheme.colorScheme.onTertiary) }
        repeat(5 - rating) { JetStar(IGShopTheme.colorScheme.onBackground) }
    }
}

@Preview
@Composable
private fun JetRatingBarPreview() {
    IGShopTheme {
        JetRatingBar(
            rating = 4,
            modifier = Modifier
        )
    }
}