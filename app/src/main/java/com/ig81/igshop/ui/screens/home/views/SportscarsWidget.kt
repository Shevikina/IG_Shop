package com.ig81.igshop.ui.screens.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.ig81.igshop.ui.theme.IGShopTheme


@Composable
fun SportscarsWidget() {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(start = 32.dp)
    ) {
        Text(
            text = stringResource(id = R.string.our_new_products_title),
            style = IGShopTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = IGShopTheme.colorScheme.onBackground
            )
        )
        val cars = listOf(
            SportscarInfo(
                carName = "Lamba-A",
                carType = "Классический спорткар",
                imagePath = "file:///android_asset/App5_Image1.jpg",
                rating = 4,
                price = 177000
            ) {},
            SportscarInfo(
                carName = "Lamba Sport",
                carType = "Премиум",
                imagePath = "file:///android_asset/App5_Image2.jpg",
                rating = 5,
                price = 500000
            ) {}
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(cars) { info ->
                SportcarCard(Modifier.width(288.dp), info)
            }
        }
    }
}

@Preview
@Composable
private fun SportscarsWidgetPreview() {
    IGShopTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(IGShopTheme.colorScheme.background)
        ) {

            Spacer(modifier = Modifier.height(32.dp))
            SportscarsWidget()
        }
    }
}