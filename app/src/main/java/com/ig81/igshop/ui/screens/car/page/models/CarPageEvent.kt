package com.ig81.igshop.ui.screens.car.page.models

sealed class CarPageEvent {
    data class EnterScreen(val carId: Int) : CarPageEvent()
    data object ReloadScreen : CarPageEvent()
    data object CloseScreen : CarPageEvent()
    data object BookCar : CarPageEvent()
}