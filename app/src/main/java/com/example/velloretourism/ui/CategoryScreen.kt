package com.example.velloretourism.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.velloretourism.data.Category
import com.example.velloretourism.ui.Utils.ScreenDimens

@Composable
fun CategoryScreen(
    screenDimens: ScreenDimens,
    categoryList: List<Category>,
    onCategoryClick: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = screenDimens.columnSize),
        modifier = modifier,
        contentPadding = PaddingValues(screenDimens.spacing),
        verticalArrangement = Arrangement.spacedBy(screenDimens.spacing),
        horizontalArrangement = Arrangement.spacedBy(screenDimens.spacing),
    ) {
        header {
            Text(
                "Start Exploring",
                fontSize = screenDimens.fontSize.times(1.3f)
            )
        }
        items(categoryList) {category ->
            CategoryCard(
                categoryName = stringResource(id = category.title),
                onCategoryClick = { onCategoryClick(category) },
                modifier = Modifier.aspectRatio(1f),
                fontSize = screenDimens.fontSize
            )
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCard(
    categoryName: String,
    onCategoryClick: () -> Unit,
    modifier: Modifier = Modifier,
    fontSize: TextUnit
) {
    Card(
        onClick = onCategoryClick,
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
    CategoryScreen(
        screenDimens = ScreenDimens.LARGE,
        categoryList = Category.values().toList(),
        onCategoryClick = {}
    )
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun CategoryScreenMediumPreview() {
    CategoryScreen(
        screenDimens = ScreenDimens.MEDIUM,
        categoryList = Category.values().toList(),
        onCategoryClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun CategoryScreenCompactPreview() {
    CategoryScreen(
        screenDimens = ScreenDimens.SMALL,
        categoryList = Category.values().toList(),
        onCategoryClick = {}
    )
}

fun LazyGridScope.header(
    content: @Composable LazyGridItemScope.() -> Unit
) {
    item(span = { GridItemSpan(this.maxLineSpan) }, content = content)
}



