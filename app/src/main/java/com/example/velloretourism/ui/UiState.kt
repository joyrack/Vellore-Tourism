package com.example.velloretourism.ui

import com.example.velloretourism.data.Category
import com.example.velloretourism.data.Place

data class UiState(
    val currentSelectedCategory: Category? = null,
    val currentSelectedPlace: Place? = null,
    val categoryPlaces: Map<Category, List<Place>> = emptyMap(),
    ) {
    val currentCategoryPlaces: List<Place> by lazy { categoryPlaces[currentSelectedCategory]!! }
}