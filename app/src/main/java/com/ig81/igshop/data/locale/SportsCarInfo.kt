package com.ig81.igshop.data.locale

data class SportsCarInfo(
    val id: Int,
    val carName: String,
    val carType: String,
    val imagePath: String,
    val rating: Int,
    val price: Int,
    val speedRating: Int,
    val corpusRating: Int,
    val shieldRating: Int,
    val description: String = ""
)