package com.example.velloretourism

import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

/**
 * Defining the different screens
 */
enum class AppScreen(@StringRes val title: Int) {
    Category(title = R.string.app_name),
    PlaceList(title = -1),
    PlaceDetail(title = -1)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TourismApp() {
    Scaffold(
        topBar = {}
    ) { innerPadding ->

    }
}