package com.ig81.igshop.ui.screens.car.page.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.ig81.igshop.R
import com.ig81.igshop.ui.theme.IGShopTheme

@Composable
fun DescriptionCard(description: String, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(
                color = IGShopTheme.colorScheme.tertiary.copy(0.1f),
                shape = RoundedCornerShape(32.dp, 32.dp, 60.dp, 60.dp)
            )
            .padding(16.dp, 0.dp, 16.dp, 37.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(7.dp),
            modifier = Modifier
                .background(
                    IGShopTheme.colorScheme.tertiary.copy(0.1f),
                    RoundedCornerShape(16.dp, 16.dp, 56.dp, 56.dp)
                )
                .heightIn(112.dp)
                .fillMaxWidth()
                .padding(36.dp, 12.dp, 33.dp, 23.dp)
        ) {
            Text(
                text = stringResource(id = R.string.description_title),
                style = IGShopTheme.typography.bodyLarge.copy(
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 0.em,
                    color = IGShopTheme.colorScheme.onBackground.copy(0.5f)
                )
            )
            Text(
                text = description,
                color = IGShopTheme.colorScheme.onBackground,
                style = IGShopTheme.typography.bodyLarge.copy(
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 1.em,
                    letterSpacing = 0.em
                )
            )
        }
    }
}

@Preview
@Composable
private fun DescriptionCardPreview() {
    IGShopTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(IGShopTheme.colorScheme.background)
                .padding(horizontal = 34.dp)
        ) {
            DescriptionCard(
                modifier = Modifier,
                description = "Лучший спорткар на всём Внешнем кольце. Его модернезированные версии завоевывают первые места на всех крупных соревнованиях в галактике!"
            )
        }
    }
}