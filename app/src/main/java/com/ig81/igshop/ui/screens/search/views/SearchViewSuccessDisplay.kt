package com.ig81.igshop.ui.screens.search.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.ig81.igshop.R
import com.ig81.igshop.data.locale.Database
import com.ig81.igshop.data.locale.ui.models.SportsCarInfo
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.ui.theme.components.JetSportCarCard


@Composable
fun SearchViewSuccessDisplay(sportsCars: List<SportsCarInfo>, onCardClick: (id: Int) -> Unit) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState(0))
    ) {
        Text(
            text = stringResource(id = R.string.sportscars_title),
            style = IGShopTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                color = IGShopTheme.colorScheme.onBackground,
                lineHeight = 1.em,
                letterSpacing = 0.em
            )
        )

        sportsCars.forEach { sportsCarInfo ->
            JetSportCarCard(
                info = sportsCarInfo,
                onClick = { onCardClick(sportsCarInfo.id) },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF2E4552)
@Composable
private fun SearchDisplayPreview() {
    IGShopTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {
            SearchViewSuccessDisplay(
                sportsCars = Database.sportsCarList,
                onCardClick = {}
            )
        }
    }
}