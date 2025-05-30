package com.ig81.igshop.ui.screens.search.views.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ig81.igshop.ui.theme.IGShopTheme
import com.microsoft.fluent.mobile.icons.R

@Composable
fun SearchField(
    searchValue: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    onLeadingIconClicked: () -> Unit,
    focusRequester: FocusRequester? = null
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        value = searchValue,
        onValueChange = onValueChange,
        modifier = modifier
            .height(47.dp)
            .let {
                if (focusRequester != null) it
                    .focusRequester(focusRequester = focusRequester)
                    .onFocusChanged { state -> if (state.isFocused) keyboardController?.show() }
                else it
            },
        singleLine = true,
        shape = IGShopTheme.shapes.small,
        placeholder = {
            Text(
                text = stringResource(id = com.ig81.igshop.R.string.search_hint),
                style = IGShopTheme.typography.bodyLarge.copy(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = IGShopTheme.colorScheme.onSurface.copy(0.5f)
                )
            )
        },
        colors = TextFieldDefaults.colors(
            // container
            unfocusedContainerColor = IGShopTheme.colorScheme.surface,
            focusedContainerColor = IGShopTheme.colorScheme.surface,
            // text
            unfocusedTextColor = IGShopTheme.colorScheme.onSurface,
            focusedTextColor = IGShopTheme.colorScheme.onSurface,
            // indicator line
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            // cursor
            cursorColor = IGShopTheme.colorScheme.onSurface
        ),
        textStyle = IGShopTheme.typography.bodyLarge.copy(
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        ),
        leadingIcon = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .size(42.dp, 47.dp)
                    .offset(x = (-3).dp)
                    .clip(RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp))
                    .clickable(onClick = onLeadingIconClicked)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_fluent_chevron_left_24_filled),
                    contentDescription = null,
                    tint = IGShopTheme.colorScheme.secondary,
                    modifier = Modifier
                        .size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                VerticalDivider(
                    color = Color(0xFFE2E2EA),
                    modifier = Modifier.heightIn(max = 24.dp)
                )
            }
        },
        trailingIcon = {
            if (searchValue.isEmpty())
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_fluent_search_48_regular),
                    contentDescription = null,
                    modifier = Modifier
                        .height(24.dp)
                        .padding(end = 33.dp),
                    tint = Color.White
                )
            else
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_fluent_dismiss_48_regular),
                    contentDescription = null,
                    modifier = Modifier
                        .height(24.dp)
                        .padding(end = 33.dp)
                        .clip(CircleShape)
                        .clickable { onValueChange("") },
                    tint = Color.White
                )
        }
    )
}

@Preview(group = "SearchStates")
@Composable
private fun SearchFieldWithPlaceholderPreview() {
    IGShopTheme {
        val searchVal = remember { mutableStateOf("") }

        SearchField(
            modifier = Modifier.fillMaxWidth(),
            searchValue = searchVal.value,
            onValueChange = { value -> Log.i("MyLog", value) },
            onLeadingIconClicked = {}
        )
    }
}

@Preview(group = "SearchStates")
@Composable
private fun SearchFieldWithValuePreview() {
    IGShopTheme {
        val searchVal = remember { mutableStateOf("Lamba") }

        SearchField(
            modifier = Modifier.fillMaxWidth(),
            searchValue = searchVal.value,
            onValueChange = { value -> Log.i("MyLog", value) },
            onLeadingIconClicked = {}
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, backgroundColor = 0xFF2E4552)
@Composable
private fun FullScreenSearchFieldPreview() {
    val searchVal = remember { mutableStateOf("Lamba") }

    IGShopTheme {
        Column(
            Modifier
                .fillMaxSize()
                .padding(32.dp)
        ) {
            SearchField(
                modifier = Modifier.fillMaxWidth(),
                searchValue = searchVal.value,
                onValueChange = { value ->
                    searchVal.value = value
                    Log.i("MyLog", value)
                },
                onLeadingIconClicked = {}
            )
        }

    }
}