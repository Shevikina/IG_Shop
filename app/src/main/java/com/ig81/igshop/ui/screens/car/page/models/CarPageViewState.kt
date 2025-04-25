package com.ig81.igshop.ui.screens.car.page.models

sealed class CarPageViewState {
    data object Loading : CarPageViewState()
    data class Error(val message: String, val icon: Int) : CarPageViewState()
    data class Display(
        val name: String,
        val type: String,
        val overallRating: Float,
        val price: Double,
        val specs: List<Int>,
        val description: String
    ) : CarPageViewState()
}