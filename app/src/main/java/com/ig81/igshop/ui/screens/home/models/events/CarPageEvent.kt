package com.ig81.igshop.ui.screens.home.models.events

sealed class CarPageEvent {
    data class EnterScreen(val carId: Int) : CarPageEvent()
    data object ReloadScreen : CarPageEvent()
    data object BookCar : CarPageEvent()
}