package com.example.velloretourism.ui

import androidx.lifecycle.ViewModel
import com.example.velloretourism.data.Category
import com.example.velloretourism.data.Place
import com.example.velloretourism.data.local.LocalPlacesDataProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    // initialize the state
    init {
        initializeUiState()
    }

    private fun initializeUiState() {
        val places: Map<Category, List<Place>> =
            LocalPlacesDataProvider.allPlaces.groupBy { it.category }
        _uiState.value = UiState(
            categoryPlaces = places
        )
    }

    fun updateCurrentCategory(category: Category) {
        _uiState.update { currentState ->
            currentState.copy(
                currentSelectedCategory = category
            )
        }
    }

    fun updateCurrentPlace(place: Place) {
        _uiState.update { currentState ->
            currentState.copy(
                currentSelectedPlace = place
            )
        }
    }

    fun removeSelectedPlace() {
        _uiState.update { currentState ->
            currentState.copy(
                currentSelectedPlace = null
            )
        }
    }
}