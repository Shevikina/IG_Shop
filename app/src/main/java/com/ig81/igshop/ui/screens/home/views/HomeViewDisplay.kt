package com.ig81.igshop.ui.screens.home.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.ui.theme.components.JetSearchField

@Composable
fun HomeViewDisplay(dispatcher: (HomeEvent) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(IGShopTheme.colorScheme.background)
            .verticalScroll(rememberScrollState(0))
    ) {
        Column(modifier = Modifier.padding(horizontal = 32.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 28.dp)
            ) {
                JetSearchField(
                    hint = stringResource(id = R.string.search_hint),
                    value = "",
                    modifier = Modifier.width(250.dp),
                    onClick = { dispatcher.invoke(HomeEvent.OpenSearchScreen) }
                )
                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.ic_main_icon),
                    contentScale = ContentScale.None,
                    contentDescription = null,
                    modifier = Modifier.height(38.dp)
                )
            }
            SpecialOffersWidget()
            Spacer(modifier = Modifier.height(32.dp))
            AchievementsWidget { dispatcher.invoke(HomeEvent.OpenAchievementsScreen) }
        }
        Spacer(modifier = Modifier.height(32.dp))
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