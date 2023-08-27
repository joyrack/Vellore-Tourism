package com.example.velloretourism.data.local

import androidx.annotation.StringRes
import com.example.velloretourism.R
import com.example.velloretourism.data.Category
import com.example.velloretourism.data.Place

object LocalPlacesDataProvider {
    val allPlaces = listOf(
        Place(
            category = Category.CAFES,
            name = R.string.chocolate_room_name,
            rating = 4.3,
            imageId = R.drawable.avatar_0,
            description = R.string.chocolate_room_description,
            menuUrl = R.string.chocolate_room_menu
        ),
        Place(
            category = Category.CAFES,
            name = R.string.chocolate_room_name,
            rating = 4.3,
            imageId = R.drawable.avatar_0,
            description = R.string.chocolate_room_description,
            menuUrl = R.string.chocolate_room_menu
        ),
        Place(
            category = Category.CAFES,
            name = R.string.chocolate_room_name,
            rating = 4.3,
            imageId = R.drawable.avatar_0,
            description = R.string.chocolate_room_description,
            menuUrl = R.string.chocolate_room_menu
        ),
        Place(
            category = Category.CAFES,
            name = R.string.chocolate_room_name,
            rating = 4.3,
            imageId = R.drawable.avatar_0,
            description = R.string.chocolate_room_description,
            menuUrl = R.string.chocolate_room_menu
        ),
    )
}