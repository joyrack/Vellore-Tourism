package com.example.velloretourism.ui

import com.example.velloretourism.data.Category
import com.example.velloretourism.data.Place

data class UiState(
    val currentCategory: Category? = null,
    val currentSelectedPlace: Place? = null,
    val categories: Map<Category, List<Place>> = emptyMap(),
    ) {
    val currentCategoryPlaces: List<Place> by lazy { categories[currentCategory]!! }
}