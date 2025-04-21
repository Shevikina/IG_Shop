package com.ig81.igshop.ui.screens.home.models.view_states

sealed class SearchViewState {
    data object Loading : SearchViewState()
    data class Error(val message: String, val icon: Int) : SearchViewState()
    data class Display(
        val query: String,
        val sportsCars: List<String>
    ) : SearchViewState()
}