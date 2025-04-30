package com.ig81.igshop.ui.screens.search.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ig81.igshop.data.locale.Database
import com.ig81.igshop.ui.screens.search.models.SearchEvent
import com.ig81.igshop.ui.screens.search.models.SearchViewState
import com.ig81.igshop.ui.screens.search.views.components.SearchField
import com.ig81.igshop.ui.theme.IGShopTheme

@Composable
fun SearchViewDisplay(dispatcher: (SearchEvent) -> Unit) {
    val viewState = remember {
        mutableStateOf<SearchViewState>(
            SearchViewState.Loading
        )
    }
    val searchState = remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 28.dp)
    ) {
        SearchField(
            searchValue = searchState.value,
            onValueChange = {
                searchState.value = it
                viewState.value = SearchViewState.Loading
                dispatcher.invoke(SearchEvent.ChangeQuery(it))
            },
            onLeadingIconClicked = { dispatcher.invoke(SearchEvent.CloseScreen) },
            modifier = Modifier.fillMaxWidth()
        )

        when (val uiState = viewState.value) {
            is SearchViewState.Loading -> {
                if (searchState.value.isEmpty()) {
                    viewState.value = SearchViewState.Error(
                        message = "Строка поиска пуста.\nВведите название искомого спорткара.",
                        icon = com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_sidebar_search_rtl_20_regular
                    )
                } else {
                    val searchResult =
                        Database.sportsCarList.filter {
                            it.carName.contains(
                                other = searchState.value,
                                ignoreCase = true
                            )
                        }

                    if (searchResult.isEmpty()) {
                        viewState.value = SearchViewState.Error(
                            message = "Спорткары по запросу \"${searchState.value}\" не найдены.\nПопробуйте ввести название иначе.",
                            icon = com.microsoft.fluent.mobile.icons.R.drawable.ic_fluent_circle_off_20_regular
                        )
                    } else {
                        viewState.value = SearchViewState.Display(
                            query = searchState.value,
                            sportsCars = searchResult
                        )
                    }
                }
            }

            is SearchViewState.Error -> {
                SearchViewError(
                    icon = uiState.icon,
                    message = uiState.message
                )
            }

            is SearchViewState.Display -> {
                SearchViewSuccessDisplay(
                    sportsCars = uiState.sportsCars,
                    onCardClick = { dispatcher.invoke(SearchEvent.OpenSportsCarPageScreen(it)) }
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF2E4552)
@Composable
private fun SearchViewDisplayPreview() {
    IGShopTheme {
        SearchViewDisplay {}
    }
}
