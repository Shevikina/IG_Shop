package com.ig81.igshop.ui.screens.home.models.view_states

sealed class HomeViewState {
    data object Loading : HomeViewState()
    data class Error(val message: String, val icon: Int) : HomeViewState()
    data class Display(
        val specialOffers: List<String>,
        val topCustomers: List<String>,
        val newProducts: List<String>
    ) : HomeViewState()
}