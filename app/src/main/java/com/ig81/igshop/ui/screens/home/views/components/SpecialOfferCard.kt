package com.ig81.igshop.ui.screens.home.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.data.locale.Database
import com.ig81.igshop.data.locale.ui.models.SpecialOfferInfo
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.utils.dashedBorder

@Composable
fun SpecialOfferCard(
    info: SpecialOfferInfo,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = IGShopTheme.colorScheme.tertiary.copy(info.backgroundAlpha),
                shape = IGShopTheme.shapes.dialog
            )
            .dashedBorder(
                width = 2.dp,
                color = IGShopTheme.colorScheme.secondary,
                shape = IGShopTheme.shapes.dialog,
                on = 6.dp,
                off = if (info.selected) 0.dp else 6.dp
            )
    ) {
        if (info.selected) {
            Icon(
                painter = painterResource(id = com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_contact_card_32_filled),
                contentDescription = null,
                tint = IGShopTheme.colorScheme.tertiary.copy(0.5f),
                modifier = Modifier
                    .padding(16.dp)
                    .size(96.dp)
            )
        }
        Text(
            text = info.number,
            style = IGShopTheme.typography.bodyLarge.copy(
                fontSize = 12.sp,
                lineHeight = 14.06.sp,
                color = IGShopTheme.colorScheme.tertiary.copy(0.75f)
            ),
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(x = 20.dp)
                .rotate(-90f)
        )
    }
}

@Preview
@Composable
private fun SpecialOfferCardPreview() {
    IGShopTheme {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(IGShopTheme.colorScheme.background)
                .padding(32.dp)
        ) {
            Database.specialOfferList.forEach { info ->
                SpecialOfferCard(
                    info = info,
                    modifier = Modifier
                        .height(125.dp)
                        .fillMaxWidth(info.width)
                )
            }
        }
    }
}