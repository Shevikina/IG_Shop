package com.ig81.igshop.ui.screens.home.models

sealed class HomeEvent {
    data object EnterScreen : HomeEvent()
    data object ReloadScreen : HomeEvent()
}