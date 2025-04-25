package com.ig81.igshop.ui.screens.car.page.models

sealed class CarPageAction {
    data class ShowDialog(
        val title: String,
        val body: String,
        val buttonText: String
    ) : CarPageAction()
}