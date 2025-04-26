package com.ig81.igshop.ui.screens.achievements.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.R
import com.ig81.igshop.data.locale.Database
import com.ig81.igshop.ui.screens.achievements.models.AchievementsEvent
import com.ig81.igshop.ui.screens.achievements.models.AchievementsViewSubState
import com.ig81.igshop.ui.screens.achievements.views.components.TabTitleButton
import com.ig81.igshop.ui.screens.home.views.components.UserRatingCard
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.ui.theme.components.JetDivider
import com.ig81.igshop.ui.theme.components.JetIconButton
import com.ig81.igshop.ui.theme.components.JetTextButton

@Composable
fun AchievementsViewDisplay(dispatcher: (AchievementsEvent) -> Unit) {
    val viewSubState =
        remember { mutableStateOf<AchievementsViewSubState>(AchievementsViewSubState.Buyers) }

    val userList = when (viewSubState.value) {
        is AchievementsViewSubState.Buyers -> {
            Database.achievementsList
        }

        is AchievementsViewSubState.VipBuyers -> {
            Database.achievementsList.filter { it.isVip }
        }
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(IGShopTheme.colorScheme.background)
            .verticalScroll(rememberScrollState(0))
            .padding(32.dp, 32.dp, 32.dp, 26.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            JetIconButton(
                vectorDrawableId = com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_chevron_left_16_filled,
                onClick = { dispatcher.invoke(AchievementsEvent.CloseScreen) }
            )
            Text(
                text = stringResource(id = R.string.achievements_title),
                color = IGShopTheme.colorScheme.onBackground,
                style = IGShopTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            )
            Icon(
                imageVector = ImageVector.vectorResource(id = com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_people_search_24_regular),
                contentDescription = "people search icon",
                tint = IGShopTheme.colorScheme.secondary,
                modifier = Modifier.size(32.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    IGShopTheme.colorScheme.surface,
                    IGShopTheme.shapes.small
                )
                .padding(start = 12.dp, end = 25.dp, bottom = 20.dp)
                .weight(1f)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                TabTitleButton(
                    stringResource(id = R.string.buyers_title),
                    colorSwitcher = { viewSubState.value == AchievementsViewSubState.Buyers },
                    onClick = { viewSubState.value = AchievementsViewSubState.Buyers }
                )
                Spacer(modifier = Modifier.width(16.dp))
                TabTitleButton(
                    stringResource(id = R.string.vip_buyers_title),
                    colorSwitcher = { viewSubState.value == AchievementsViewSubState.VipBuyers },
                    onClick = { viewSubState.value = AchievementsViewSubState.VipBuyers }
                )
            }

            userList.forEachIndexed { idx, userInfo ->
                UserRatingCard(idx, userInfo)
                if (userInfo != userList.last())
                    JetDivider()
            }
        }

        Spacer(modifier = Modifier.height(32.dp)) // full space is 64.dp
        JetTextButton(
            text = stringResource(id = R.string.view_full_btn),
            modifier = Modifier.fillMaxWidth(),
            onClick = { dispatcher.invoke(AchievementsEvent.ViewFullList) }
        )
    }
}

@Preview
@Composable
private fun AchievementsViewDisplayPreview() {
    IGShopTheme {
        AchievementsViewDisplay {}
    }
}