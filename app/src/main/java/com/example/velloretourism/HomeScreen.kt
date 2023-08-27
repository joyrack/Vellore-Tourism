package com.example.velloretourism

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.velloretourism.ui.CategoryScreen
import com.example.velloretourism.ui.MainViewModel
import com.example.velloretourism.ui.Utils.ContentType
import com.example.velloretourism.ui.Utils.ScreenDimens
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.velloretourism.data.Category
import com.example.velloretourism.data.local.LocalPlacesDataProvider
import com.example.velloretourism.ui.PlaceDetail
import com.example.velloretourism.ui.PlaceListAndDetail
import com.example.velloretourism.ui.PlacesList

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
fun TourismApp(
    windowWidthSizeClass: WindowWidthSizeClass,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: MainViewModel = viewModel()
) {
    val contentType: ContentType
    val screenDimens: ScreenDimens

    when(windowWidthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            contentType = ContentType.LIST_ONLY
            screenDimens = ScreenDimens.SMALL
        }
        WindowWidthSizeClass.Medium -> {
            contentType = ContentType.LIST_ONLY
            screenDimens = ScreenDimens.MEDIUM
        }
        WindowWidthSizeClass.Expanded -> {
            contentType = ContentType.LIST_AND_DETAIL
            screenDimens = ScreenDimens.LARGE
        }
        else -> {
            contentType = ContentType.LIST_ONLY
            screenDimens = ScreenDimens.SMALL
        }
    }

    // get the list of all the categories
    val categoryList = Category.values().toList()

    Scaffold(
        topBar = {}
    ) { innerPadding ->
        val uiState = viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = AppScreen.Category.name,
            modifier = Modifier.padding(innerPadding)
            ) {

            composable(route = AppScreen.Category.name) {
                CategoryScreen(
                    screenDimens = screenDimens,
                    categoryList = categoryList,
                    onCategoryClick = {
                        viewModel.updateCurrentCategory(it)     // update the state
                        navController.navigate(AppScreen.PlaceList.name)    // change screen
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }

            composable(route = AppScreen.PlaceList.name) {
                if(contentType == ContentType.LIST_AND_DETAIL) {
                    PlaceListAndDetail(
                        placesList = uiState.value.currentCategoryPlaces,
                        onItemClick = {
                            viewModel.updateCurrentPlace(it)    // update the state
                        },
                        modifier = Modifier.fillMaxSize(),
                        currentSelectedPlace = uiState.value.currentSelectedPlace
                    )
                }
                else {
                    PlacesList(
                        placesList = uiState.value.currentCategoryPlaces,
                        modifier = Modifier.fillMaxSize(),
                        onItemClick = {
                            viewModel.updateCurrentPlace(it)    // update the state
                            navController.navigate(AppScreen.PlaceDetail.name)      // change screen
                        },
                        currentSelectedPlace = uiState.value.currentSelectedPlace
                    )
                }
            }
            composable(route = AppScreen.PlaceDetail.name) {
                PlaceDetail(
                    place = uiState.value.currentSelectedPlace,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

    }
}