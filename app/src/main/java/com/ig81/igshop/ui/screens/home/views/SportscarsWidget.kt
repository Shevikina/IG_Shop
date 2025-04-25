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
import com.ig81.igshop.data.locale.Database
import com.ig81.igshop.ui.screens.home.models.HomeEvent
import com.ig81.igshop.ui.theme.IGShopTheme


@Composable
fun SportsCarsWidget(dispatcher: (HomeEvent) -> Unit) {
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

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(Database.sportsCarList) { info ->
                SportCarCard(
                    modifier = Modifier.width(288.dp),
                    info = info,
                    onClick = { dispatcher.invoke(HomeEvent.OpenSportsCarPageScreen(info.id)) })
            }
        }
    }
}

@Preview
@Composable
private fun SportsCarsWidgetPreview() {
    IGShopTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(IGShopTheme.colorScheme.background)
        ) {

            Spacer(modifier = Modifier.height(32.dp))
            SportsCarsWidget {}
        }
    }
}