package com.ig81.igshop.ui.screens.car.page.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.R
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.ui.theme.components.JetCircularRatingBar

@Composable
private fun SpecificationCardItem(title: String, rating: Int, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.size(81.dp, 74.dp)
    ) {
        Text(
            text = title,
            style = IGShopTheme.typography.bodyLarge.copy(
                fontSize = 12.sp,
                color = IGShopTheme.colorScheme.onBackground
            ),
            modifier = Modifier.align(Alignment.TopCenter)
        )
        JetCircularRatingBar(
            rating = rating,
            backgroundColor = IGShopTheme.colorScheme.background.copy(0.4f),
            Modifier
                .padding(top = 6.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun SpecificationCard(
    speedRating: Int,
    corpusRating: Int,
    shieldRating: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(
                color = IGShopTheme.colorScheme.tertiary.copy(0.1f),
                shape = RoundedCornerShape(60.dp, 60.dp, 32.dp, 32.dp)
            )
            .padding(horizontal = 15.dp)
    ) {
        Text(
            text = stringResource(id = R.string.specifications_title),
            style = IGShopTheme.typography.bodyLarge.copy(
                fontSize = 12.sp,
                color = IGShopTheme.colorScheme.onBackground.copy(0.5f)
            ),
            modifier = Modifier.padding(12.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(32.dp),
            modifier = Modifier
                .background(
                    color = IGShopTheme.colorScheme.tertiary.copy(0.1f),
                    shape = RoundedCornerShape(56.dp, 56.dp, 16.dp, 16.dp)
                )
                .padding(vertical = 19.dp, horizontal = 4.dp)
        )
        {
            SpecificationCardItem(
                title = stringResource(id = R.string.speed_title),
                rating = speedRating
            )
            SpecificationCardItem(
                title = stringResource(id = R.string.сorpus_title),
                rating = corpusRating
            )
            SpecificationCardItem(
                title = stringResource(id = R.string.shield_title),
                rating = shieldRating
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun SpecificationCardPreview() {
    IGShopTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(IGShopTheme.colorScheme.background)
                .padding(start = 32.dp, end = 36.dp)
        ) {
            SpecificationCard(
                4, 5, 3,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}