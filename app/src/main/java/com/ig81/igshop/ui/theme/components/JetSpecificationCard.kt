package com.ig81.igshop.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.ui.theme.robotoFonts

data class CardItemInfo(val title: String, val rating: Int)

@Composable
fun JetCardItem(info: CardItemInfo, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(81.dp, 74.dp)
    ) {
        Text(
            text = info.title,
            fontSize = 12.sp,
            fontFamily = robotoFonts,
            fontWeight = FontWeight.Normal,
            color = IGShopTheme.colorScheme.onBackground,
            modifier = Modifier.align(Alignment.TopCenter)
        )
        JetCircularRatingBar(
            rating = info.rating,
            backgroundColor = IGShopTheme.colorScheme.background.copy(0.4f),
            Modifier
                .padding(top = 6.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun JetSpecificationCard(specifications: List<CardItemInfo>, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(346.dp, 149.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(60.dp, 60.dp, 32.dp, 32.dp))
                .background(IGShopTheme.colorScheme.surface.copy(0.1f))
        ) {
            Text(
                text = "Спецификации",
                fontFamily = robotoFonts,
                fontSize = 12.sp,
                color = IGShopTheme.colorScheme.onBackground.copy(0.5f),
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(12.dp)
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(315.dp, 113.dp)
                    .align(Alignment.BottomCenter)
                    .clip(RoundedCornerShape(56.dp, 56.dp, 16.dp, 16.dp))
                    .background(IGShopTheme.colorScheme.surface.copy(0.1f))
            )
            {
                JetCardItem(specifications.first(), Modifier.align(Alignment.CenterStart))
                JetCardItem(specifications.elementAt(1), Modifier.align(Alignment.Center))
                JetCardItem(specifications.last(), Modifier.align(Alignment.CenterEnd))
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun JetSpecificationCardPreview() {
    IGShopTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(346.dp, 149.dp)
                .background(IGShopTheme.colorScheme.background)
        ) {
            JetSpecificationCard(
                specifications = listOf(
                    CardItemInfo("Скорость", 4),
                    CardItemInfo("Корпус", 5),
                    CardItemInfo("Щиты", 3)
                ),
                modifier = Modifier
            )
        }
    }
}