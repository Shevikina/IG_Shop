package com.ig81.igshop.ui.screens.home.models

data class SportsCarInfo(
    val carName: String,
    val carType: String,
    var imagePath: String,
    var rating: Int,
    var price: Int,
    val onClick: (() -> Unit)? = null
)