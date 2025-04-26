package com.ig81.igshop.ui.screens.home.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.ig81.igshop.data.locale.Database
import com.ig81.igshop.data.locale.ui.models.UserRatingInfo
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.ui.theme.components.JetDivider
import kotlin.math.pow

@Composable
fun UserRatingCard(
    idx: Int,
    userRatingInfo: UserRatingInfo,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(horizontal = 7.dp)
    ) {
        val numAlpha =
            if (userRatingInfo.number > 3)
                0f
            else
                1 / (2.0f.pow(userRatingInfo.number - 1))

        Text(
            text = (idx+1).toString(),
            style = IGShopTheme.typography.bodyLarge.copy(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 16.41.sp,
                color = IGShopTheme.colorScheme.tertiary.copy(alpha = numAlpha)
            )
        )
        AsyncImage(
            model = userRatingInfo.imagePath,
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .size(32.dp)
                .border(
                    1.dp,
                    IGShopTheme.colorScheme.onPrimary,
                    RoundedCornerShape(6.dp)
                )
                .padding(2.dp)
        )
        Text(
            text = userRatingInfo.name,
            style = IGShopTheme.typography.bodyLarge.copy(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 16.41.sp,
                color = IGShopTheme.colorScheme.onSurface
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "${userRatingInfo.balls} б.",
            style = IGShopTheme.typography.bodyLarge.copy(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 16.41.sp,
                color = IGShopTheme.colorScheme.onSurface
            )
        )
    }
}


@Preview
@Composable
private fun UserRatingCardPreview() {
    IGShopTheme {
        UserRatingCard(
            idx = 0,
            userRatingInfo = Database.achievementsList[0],
            modifier = Modifier
        )
    }
}

@Preview
@Composable
private fun UserRatingCardsPreview() {
    IGShopTheme {
        Box(
            modifier = Modifier
                .background(IGShopTheme.colorScheme.background)
                .padding(32.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        IGShopTheme.colorScheme.surface,
                        IGShopTheme.shapes.small
                    )
                    .padding(start = 12.dp, end = 25.dp, top = 18.dp, bottom = 20.dp)
            ) {
                Database.achievementsList.forEachIndexed { idx, userInfo ->
                    UserRatingCard(idx, userInfo)
                    if (userInfo != Database.achievementsList.last())
                        JetDivider()
                }
            }
        }
    }
}

@Preview
@Composable
private fun VipUserRatingCardsPreview() {
    IGShopTheme {
        val userList = Database.achievementsList.filter { it.isVip }

        Box(
            modifier = Modifier
                .background(IGShopTheme.colorScheme.background)
                .padding(32.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        IGShopTheme.colorScheme.surface,
                        IGShopTheme.shapes.small
                    )
                    .padding(start = 12.dp, end = 25.dp, top = 18.dp, bottom = 20.dp)
            ) {
                userList.forEachIndexed { idx, userInfo ->
                    UserRatingCard(idx, userInfo)
                    if (userInfo != userList.last())
                        JetDivider()
                }
            }
        }
    }
}