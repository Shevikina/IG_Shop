package com.ig81.igshop.ui.screens.home.views

import androidx.compose.foundation.background
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.R
import com.ig81.igshop.data.locale.Database
import com.ig81.igshop.ui.theme.IGShopTheme

@Composable
fun SpecialOffersWidget() {
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

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy((-148).dp),
            reverseLayout = true
        ) {
            items(Database.specialOfferList) { card ->
                Box(
                    modifier = Modifier
                        .background(
                            color = IGShopTheme.colorScheme.background,
                            shape = IGShopTheme.shapes.dialog
                        )
                        .wrapContentSize()
                ) {
                    SpecialOfferCard(
                        info = card,
                        modifier = Modifier.size(206.dp, 125.dp)
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