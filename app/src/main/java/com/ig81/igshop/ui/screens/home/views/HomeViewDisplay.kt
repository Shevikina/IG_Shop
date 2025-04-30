package com.ig81.igshop.ui.screens.home.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ig81.igshop.R
import com.ig81.igshop.ui.screens.home.models.HomeEvent
import com.ig81.igshop.ui.screens.home.views.components.AchievementsWidget
import com.ig81.igshop.ui.screens.home.views.components.SpecialOffersWidget
import com.ig81.igshop.ui.screens.home.views.components.SportsCarsWidget
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.ui.theme.components.JetSearchField

@Composable
fun HomeViewDisplay(dispatcher: (HomeEvent) -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState(0))
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 32.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 28.dp)
            ) {
                JetSearchField(
                    hint = stringResource(id = R.string.search_hint),
                    value = "",
                    modifier = Modifier.weight(1f),
                    onClick = { dispatcher.invoke(HomeEvent.OpenSearchScreen) }
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_main_icon),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier.size(76.dp, 38.dp)
                )
            }

            SpecialOffersWidget()

            Spacer(modifier = Modifier.height(32.dp))

            AchievementsWidget { dispatcher.invoke(HomeEvent.OpenAchievementsScreen) }
        }

        SportsCarsWidget(dispatcher)
    }
}

@Preview
@Composable
private fun HomeViewDisplayPreview() {
    IGShopTheme {
        HomeViewDisplay {}
    }
}