package com.ig81.igshop.data.locale.entity

data class SportcarDetails(
    val name: String,
    val type: String,
    val stars: Int,
    val price: Int,
    val description: String,
    val specifications: List<SportcarSpecification>
)
