package com.ig81.igshop.models.view_states

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