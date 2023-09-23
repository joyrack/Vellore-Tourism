package com.example.velloretourism.data.local

import androidx.annotation.StringRes
import com.example.velloretourism.R
import com.example.velloretourism.data.Category
import com.example.velloretourism.data.Place

object LocalPlacesDataProvider {
    val allPlaces = listOf(
        Place(
            category = Category.SPORTS,
            name = R.string.a_name,
            rating = 4.3,
            imageId = R.drawable.avatar_0,
            description = R.string.a_desc,
            menuUrl = -1
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
            category = Category.ADVENTURE_SPOTS,
            name = R.string.b_name,
            rating = 4.3,
            imageId = R.drawable.avatar_0,
            description = R.string.b_desc,
            menuUrl = -1
        ),
        Place(
            category = Category.RESTAURANTS,
            name = R.string.c_name,
            rating = 4.3,
            imageId = R.drawable.avatar_0,
            description = R.string.c_desc,
            menuUrl = R.string.chocolate_room_menu
        ),
        Place(
            category = Category.SHOPPING_CENTERS,
            name = R.string.d_name,
            rating = 4.1,
            imageId = R.drawable.avatar_0,
            description = R.string.d_desc,
            menuUrl = -1
        ),
        Place(
            category = Category.HISTORIC_PLACES,
            name = R.string.e_name,
            rating = 4.1,
            imageId = R.drawable.avatar_0,
            description = R.string.e_desc,
            menuUrl = -1
        ),
        Place(
            category = Category.CAFES,
            name = R.string.seventh_heaven_name,
            rating = 4.1,
            imageId = R.drawable.avatar_0,
            description = R.string.seventh_heaven_description,
            menuUrl = R.string.seventh_heaven_menu
        ),
        Place(
            category = Category.SPORTS,
            name = R.string.f_name,
            rating = 3.6,
            imageId = R.drawable.avatar_0,
            description = R.string.f_desc,
            menuUrl = -1
        )
    )
}