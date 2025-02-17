package com.ig81.igshop.ui.screens.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.ui.theme.IGShopTheme

@Composable
private fun CustomDiv() = Divider(
    modifier = Modifier.padding(vertical = 8.dp),
    thickness = 2.dp,
    color = IGShopTheme.colorScheme.tertiary.copy(0.25f)
)

@Composable
fun AchievementsWidget(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = modifier
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(id = com.ig81.igshop.R.string.achievements_and_awards_title),
                style = IGShopTheme.typography.bodyLarge.copy(
                    color = IGShopTheme.colorScheme.onBackground,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(id = com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_filter_24_filled),
                contentDescription = null,
                tint = IGShopTheme.colorScheme.secondary
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    IGShopTheme.colorScheme.surface,
                    IGShopTheme.shapes.small
                )
                .let {
                    if (onClick != null) it
                        .clip(IGShopTheme.shapes.small)
                        .clickable(onClick = onClick) else it
                }
                .padding(start = 12.dp, end = 25.dp, top = 18.dp, bottom = 20.dp)
        ) {
            UserRatingCard(1, "Джонни Джонсон", 123)
            CustomDiv()
            UserRatingCard(2, "Мэри Мэроу", 102)
            CustomDiv()
            UserRatingCard(3, "Дики Дуо", 71)
        }
    }
}

@Preview
@Composable
private fun AchievementsWidgetPreview() {
    IGShopTheme {
        Box(
            modifier = Modifier
                .background(IGShopTheme.colorScheme.background)
                .padding(32.dp)
        ) {
            AchievementsWidget {}
        }
    }
}