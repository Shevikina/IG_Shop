package com.ig81.igshop.models

sealed class AchievementsViewState {
    data object Loading : AchievementsViewState()
    data class Error(val message: String, val icon: Int) : AchievementsViewState()
    data class Display(
        val regularCustomers: List<String>,
        val vipCustomers: List<String>
    ) : AchievementsViewState()
}