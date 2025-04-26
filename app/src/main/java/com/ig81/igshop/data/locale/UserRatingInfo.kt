package com.ig81.igshop.data.locale

data class UserRatingInfo(
    val number: Int,
    val name: String,
    val balls: Int,
    val isVip: Boolean = false,
    val imagePath: String = "file:///android_asset/user_image.png",
)
