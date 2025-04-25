package com.ig81.igshop.ui.screens.home.views

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
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.ig81.igshop.ui.theme.IGShopTheme
import kotlin.math.pow

@Composable
fun UserRatingCard(
    number: Int,
    name: String,
    balls: Int,
    imagePath: String = "",
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(horizontal = 7.dp)
    ) {
        val numAlpha = 1 / (2.0.pow(number - 1))
        Text(
            text = number.toString(),
            style = IGShopTheme.typography.bodyLarge.copy(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 16.41.sp,
                color = IGShopTheme.colorScheme.tertiary.copy(alpha = numAlpha.toFloat())
            )
        )
        AsyncImage(
            model = if (imagePath.isEmpty()) "file:///android_asset/user_image.png" else imagePath,
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
            text = name,
            style = IGShopTheme.typography.bodyLarge.copy(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                lineHeight = 16.41.sp,
                color = IGShopTheme.colorScheme.onSurface
            )
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "$balls б.",
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
                UserRatingCard(
                    1,
                    "Джонни Джонсон",
                    123,
                    "",
                    Modifier
                )
                Divider(
                    modifier = Modifier.padding(vertical = 8.dp),
                    thickness = 2.dp,
                    color = IGShopTheme.colorScheme.tertiary.copy(0.25f)
                )
                UserRatingCard(
                    2,
                    "Мэри Мэроу",
                    102,
                    "",
                    Modifier
                )
                Divider(
                    modifier = Modifier.padding(vertical = 8.dp),
                    thickness = 2.dp,
                    color = IGShopTheme.colorScheme.tertiary.copy(0.25f)
                )
                UserRatingCard(
                    3,
                    "Дики Дуо",
                    71,
                    "",
                    Modifier
                )
            }
        }
    }
}