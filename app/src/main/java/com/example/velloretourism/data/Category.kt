package com.example.velloretourism.data

import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import com.example.velloretourism.R

/**
 * The different categories of places in our app
 */
enum class Category(@StringRes val title: Int) {
    RESTAURANTS(title = R.string.restaurants),
    ADVENTURE_SPOTS(title = R.string.adventure_spots),
    CAFES(title = R.string.cafes),
    SPORTS(title = R.string.sports),
    SHOPPING_CENTERS(title = R.string.shopping_centers),
    HISTORIC_PLACES(title = R.string.historic_places)
}