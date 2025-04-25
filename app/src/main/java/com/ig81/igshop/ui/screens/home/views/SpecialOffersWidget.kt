package com.ig81.igshop.ui.screens.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.R
import com.ig81.igshop.ui.screens.home.models.CardInfo
import com.ig81.igshop.ui.theme.IGShopTheme

@Composable
fun SpecialOffersWidget(
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(id = R.string.special_offers_title),
            style = IGShopTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                lineHeight = 21.09.sp,
                color = IGShopTheme.colorScheme.onBackground
            )
        )

        val cards = listOf(
            CardInfo("№ 364 154", 0.03f, onClick = {}),
            CardInfo("№ 121 453", 0.08f, onClick = {}),
            CardInfo("№ 105 423", 0.18f, onClick = {}),
            CardInfo("№ 103 436", 0.23f, selected = true, onClick = {})
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy((-148).dp),
            reverseLayout = true
        ) {
            items(cards) { card ->
                Box(
                    modifier = Modifier
                        .background(
                            IGShopTheme.colorScheme.background,
                            IGShopTheme.shapes.dialog
                        )
                        .wrapContentSize()
                ) {

                    SpecialOfferCard(
                        card.num,
                        card.selected,
                        card.alpha,
                        modifier = Modifier
                            .size(206.dp, 125.dp)
                            .let {
                                if (card.onClick != null) it
                                    .clip(IGShopTheme.shapes.dialog)
                                    .clickable(onClick = card.onClick) else it
                            }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun SpecialOffersWidgetPreview() {
    IGShopTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(IGShopTheme.colorScheme.background)
                .padding(32.dp)
        ) {
            SpecialOffersWidget()
        }
    }
}