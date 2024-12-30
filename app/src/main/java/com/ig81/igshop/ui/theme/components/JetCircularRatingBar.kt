package com.ig81.igshop.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import com.microsoft.fluent.mobile.icons.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.ui.theme.IGShopTheme
import com.ig81.igshop.ui.theme.StarColor
import com.ig81.igshop.ui.theme.robotoFonts

@Composable
fun JetSimpleStar(color: Color, modifier: Modifier = Modifier.size(16.dp)) {
    Icon(
        painter = painterResource(id = R.drawable.ic_fluent_star_24_filled),
        tint = color,
        contentDescription = "Icon with star",
        modifier = modifier
    )
}

@Composable
fun JetStar(isActive: Boolean = false, tintBackground:Color, modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(16.dp)
    ) {
        if (!isActive) {
            JetSimpleStar(IGShopTheme.colorScheme.background)
            JetSimpleStar(tintBackground)
            JetSimpleStar(IGShopTheme.colorScheme.surface.copy(0.4f))
        }
        JetSimpleStar(
            color = if (isActive) StarColor else tintBackground,
            modifier = Modifier.size(if (isActive) 16.dp else 11.dp)
        )
    }
}

@Composable
fun JetCircularRatingBar(rating: Int, backgroundColor:Color, modifier: Modifier) {
    if (rating !in 0..5) return

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(width = 56.dp, height = 56.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(5.dp)
                .border(
                    5.dp,
                    IGShopTheme.colorScheme.surface.copy(0.25f),
                    RoundedCornerShape(24.dp)
                )
                .size(47.dp)
        )
        {
            Text(
                text = rating.toString(),
                color = IGShopTheme.colorScheme.surface,
                fontSize = 14.sp,
                fontFamily = robotoFonts,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
        JetStar(
            rating > 0,
            backgroundColor,
            Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-1).dp)
        )
        Box(
            Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(bottom = 5.dp)

        ) {
            JetStar(rating > 4, backgroundColor, Modifier.align(Alignment.CenterStart))
            JetStar(rating > 1, backgroundColor, Modifier.align(Alignment.CenterEnd))
        }
        Box(
            Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(start = 8.dp, end = 8.dp, bottom = 2.dp)

        ) {
            JetStar(rating > 3, backgroundColor, Modifier.align(Alignment.CenterStart))
            JetStar(rating > 2, backgroundColor, Modifier.align(Alignment.CenterEnd))
        }
    }
}

@Preview(showBackground = false)
@Composable
fun JetCircularRatingBarPreview() {
    IGShopTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(width = 56.dp, height = 56.dp)
                .background(IGShopTheme.colorScheme.background)
        ) {
        JetCircularRatingBar(
        rating = 3,
        backgroundColor = IGShopTheme.colorScheme.background,
        modifier = Modifier
        )
    }
    }
}
