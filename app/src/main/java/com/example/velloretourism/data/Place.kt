package com.example.velloretourism.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place(
    val category: Category,
    @StringRes val name: Int,
    val rating: Double,
    @DrawableRes val imageId: Int,
    @StringRes val description: Int,
    @StringRes val menuUrl: Int,
)
