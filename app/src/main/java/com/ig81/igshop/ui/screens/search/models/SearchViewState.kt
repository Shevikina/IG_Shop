package com.ig81.igshop.ui.screens.search.models

import com.ig81.igshop.data.locale.ui.models.SportsCarInfo

sealed class SearchViewState {
    data object Loading : SearchViewState()
    data class Error(val message: String, val icon: Int) : SearchViewState()
    data class Display(
        val query: String,
        val sportsCars: List<SportsCarInfo>
    ) : SearchViewState()
}