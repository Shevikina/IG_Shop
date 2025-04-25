package com.ig81.igshop.ui.screens.home.models

data class SportsCarInfo(
    val id: Int,
    val carName: String,
    val carType: String,
    val imagePath: String,
    val rating: Int,
    val price: Int,
    val speedRating: Int,
    val caseRating: Int,
    val shieldsRating: Int,
    val description: String = ""
)