package com.example.velloretourism.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.W
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.velloretourism.data.Category
import com.example.velloretourism.data.local.LocalCategoriesDataProvider

@Composable
fun CategoryScreen(
    windowWidthSizeClass: WindowWidthSizeClass,
    onCategoryClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    val categoryList = LocalCategoriesDataProvider.allCategories.map { category -> stringResource(id = category) }

    val spacing : Dp
    val columnSize : Dp
    val fontSize: TextUnit

    when(windowWidthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            spacing = 16.dp
            columnSize = 110.dp
            fontSize = 16.sp
        }
        WindowWidthSizeClass.Medium -> {
            spacing = 32.dp
            columnSize = 170.dp
            fontSize = 20.sp
        }
        WindowWidthSizeClass.Expanded -> {
            spacing = 56.dp
            columnSize = 240.dp
            fontSize = 24.sp
        }
        else -> {
            spacing = 16.dp
            columnSize = 110.dp
            fontSize = 16.sp
        }
    }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = columnSize),
        modifier = modifier,
        contentPadding = PaddingValues(spacing),
        verticalArrangement = Arrangement.spacedBy(spacing),
        horizontalArrangement = Arrangement.spacedBy(spacing),
    ) {
        header {
            Text(
                "Start Exploring",
                fontSize = fontSize.times(1.3f)
            )
        }
        items(categoryList) {
            CategoryCard(
                categoryName = it,
                onCategoryClick = {},
                modifier = Modifier.aspectRatio(1f),
                fontSize = fontSize
            )
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCard(
    categoryName: String,
    onCategoryClick: (Category) -> Unit,
    modifier: Modifier = Modifier,
    fontSize: TextUnit
) {
    Card(
        onClick = {},
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer),
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                categoryName,
                textAlign = TextAlign.Center,
                fontSize = fontSize
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, widthDp = 1000)
@Composable
fun CategoryScreenExpandedPreview() {
    CategoryScreen(windowWidthSizeClass = WindowWidthSizeClass.Expanded, onCategoryClick = {})
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun CategoryScreenMediumPreview() {
    CategoryScreen(windowWidthSizeClass = WindowWidthSizeClass.Medium, onCategoryClick = {})
}

@Preview(showBackground = true)
@Composable
fun CategoryScreenCompactPreview() {
    CategoryScreen(windowWidthSizeClass = WindowWidthSizeClass.Compact, onCategoryClick = {})
}

fun LazyGridScope.header(
    content: @Composable LazyGridItemScope.() -> Unit
) {
    item(span = { GridItemSpan(this.maxLineSpan) }, content = content)
}



