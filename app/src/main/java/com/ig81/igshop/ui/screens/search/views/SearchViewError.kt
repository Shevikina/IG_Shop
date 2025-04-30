package com.ig81.igshop.ui.screens.search.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.ig81.igshop.ui.theme.IGShopTheme
import com.microsoft.fluent.mobile.icons.R

@Composable
fun SearchViewError(
    icon: Int,
    message: String
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = icon),
            modifier = Modifier.size(42.dp),
            tint = IGShopTheme.colorScheme.primary.copy(0.5f),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = message,
            style = IGShopTheme.typography.bodyLarge.copy(
                fontSize = 14.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                letterSpacing = 0.em,
            ),
            modifier = Modifier.padding(horizontal = 32.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF2E4552)
@Composable
private fun SearchViewErrorEmptyQueryPreview() {
    IGShopTheme {
        SearchViewError(
            message = "Строка поиска пуста.\nВведите название искомого спорткара.",
            icon = R.drawable.ic_fluent_sidebar_search_rtl_20_regular
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF2E4552)
@Composable
private fun SearchViewErrorEmptyResultPreview() {
    IGShopTheme {
        SearchViewError(
            message = "Спорткары по запросу \"...\" не найдены.\nПопробуйте ввести название иначе.",
            icon = R.drawable.ic_fluent_circle_off_20_regular
        )
    }
}
