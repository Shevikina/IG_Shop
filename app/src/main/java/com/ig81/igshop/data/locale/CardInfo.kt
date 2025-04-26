package com.ig81.igshop.data.locale

data class CardInfo(
    val num: String,
    val alpha: Float,
    var selected: Boolean = false,
    val onClick: (() -> Unit)? = null
)