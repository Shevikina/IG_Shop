package com.ig81.igshop.ui.screens.home.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.ui.theme.components.JetRatingBar

private fun Int.getFormatted(): String {
    var res = ""
    var tmp = this
    while (tmp > 0) {
        val toAdd = if (tmp % 1000 == 0) "000" else "${tmp % 1000}"
        res = "$toAdd $res"
        tmp /= 1000
    }
    return res.trim()
}

data class SportscarInfo(
    val carName: String,
    val carType: String,
    var imagePath: String,
    var rating: Int,
    var price: Int,
    val onClick: (() -> Unit)? = null
)

@Composable
fun SportcarCard(
    modifier: Modifier = Modifier,
    info: SportscarInfo
) {
    val cardColor = Color(0xFFEBEBEB)

    Box(
        modifier = modifier
            .heightIn(min = 96.dp)
            .background(
                IGShopTheme.colorScheme.surface,
                IGShopTheme.shapes.medium
            )
            .let {
                if (info.onClick != null) it
                    .clip(IGShopTheme.shapes.medium)
                    .clickable(onClick = info.onClick) else it
            }
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            AsyncImage(
                model = info.imagePath,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(IGShopTheme.shapes.medium)
                    .background(Color.Gray)
            )
            Column {
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = 18.sp,
                                color = IGShopTheme.colorScheme.tertiary
                            )
                        ) {
                            append(info.carName)
                        }
                        withStyle(
                            SpanStyle(
                                fontSize = 13.sp,
                                color = cardColor
                            )
                        ) {
                            append("\n")
                            append(info.carType)
                        }
                    },
                    style = IGShopTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Medium,
                        letterSpacing = TextUnit.Unspecified
                    ),
                    lineHeight = 18.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    JetRatingBar(
                        info.rating,
                        modifier = Modifier.size(92.dp, 16.dp)
                    )
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = "${info.price.getFormatted()} Kr",
                        color = cardColor,
                        style = IGShopTheme.typography.bodyLarge.copy(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Light
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun TourCardPreview() {
    IGShopTheme {
        Box(
            modifier = Modifier
                .background(IGShopTheme.colorScheme.background)
                .padding(32.dp)
        ) {
            SportcarCard(
                modifier = Modifier.width(288.dp),
                info = SportscarInfo(
                    carName = "Lamba-A",
                    carType = "Классический спорткар",
                    imagePath = "file:///android_asset/App5_Image1.jpg",
                    rating = 4,
                    price = 177000
                ) {}
            )
        }
    }
}