package com.ig81.igshop.ui.screens.home.models

sealed class HomeEvent {
    data object EnterScreen : HomeEvent()
    data object ReloadScreen : HomeEvent()
    data object OpenSearchScreen : HomeEvent()
    data class OpenSportsCarPageScreen(val carId: Int) : HomeEvent()
    data object OpenAchievementsScreen : HomeEvent()

}