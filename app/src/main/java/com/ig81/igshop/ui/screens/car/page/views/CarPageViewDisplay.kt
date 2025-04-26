package com.ig81.igshop.ui.screens.car.page.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ig81.igshop.R
import com.ig81.igshop.data.locale.Database
import com.ig81.igshop.ui.screens.car.page.models.CarPageEvent
import com.ig81.igshop.ui.screens.car.page.views.components.DescriptionCard
import com.ig81.igshop.ui.screens.car.page.views.components.SpecificationCard
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.ui.theme.components.JetDivider
import com.ig81.igshop.ui.theme.components.JetIconButton
import com.ig81.igshop.ui.theme.components.JetSportCarCard
import com.ig81.igshop.ui.theme.components.JetTextButton

@Composable
fun CarPageViewDisplay(carId: Int, dispatcher: (CarPageEvent) -> Unit) {
    val cardInfo = Database.sportsCarList.first { it.id == carId }

    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(IGShopTheme.colorScheme.background)
            .verticalScroll(rememberScrollState(0))
            .padding(32.dp, 32.dp, 32.dp, 26.dp)
    ) {
        JetIconButton(
            vectorDrawableId = com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_chevron_left_16_filled,
            onClick = { dispatcher.invoke(CarPageEvent.CloseScreen) }
        )

        JetSportCarCard(info = cardInfo)

        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpecificationCard(
                speedRating = cardInfo.speedRating,
                corpusRating = cardInfo.corpusRating,
                shieldRating = cardInfo.shieldRating
            )
            JetDivider(PaddingValues(horizontal = 30.dp))
            DescriptionCard(
                description = cardInfo.description
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        JetTextButton(
            text = stringResource(id = R.string.request_btn),
            modifier = Modifier.fillMaxWidth(),
            onClick = { dispatcher.invoke(CarPageEvent.BookCar) }
        )
    }
}

@Preview
@Composable
private fun CarPageViewDisplayPreview() {
    IGShopTheme {
        CarPageViewDisplay(0) {}
    }
}