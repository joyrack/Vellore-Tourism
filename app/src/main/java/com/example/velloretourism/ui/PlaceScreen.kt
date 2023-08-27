package com.example.velloretourism.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.velloretourism.data.Place
import com.example.velloretourism.data.local.LocalPlacesDataProvider
import com.example.velloretourism.ui.Utils.ContentType

//@Composable
//fun PlaceScreen(
//    windowWidthSizeClass: WindowWidthSizeClass,
//    modifier: Modifier,
//) {
//
//    val contentType = when(windowWidthSizeClass) {
//        WindowWidthSizeClass.Compact -> {
//            ContentType.LIST_ONLY
//        }
//        WindowWidthSizeClass.Medium -> {
//            ContentType.LIST_ONLY
//        }
//        WindowWidthSizeClass.Expanded -> {
//            ContentType.LIST_AND_DETAIL
//        }
//        else -> {
//            ContentType.LIST_ONLY
//        }
//    }
//
//    val placesList = LocalPlacesDataProvider.allPlaces
//
//    if(contentType == ContentType.LIST_AND_DETAIL) {
//        PlaceListAndDetail(
//            placesList = placesList,
//            onItemClick = {}
//        )
//    }
//    else {
//        PlacesList(
//            placesList = placesList,
//            modifier = modifier,
//            onItemClick = {}
//        )
//    }
//}

@Composable
fun PlacesList(
    placesList: List<Place>,
    onItemClick: (Place) -> Unit,
    modifier: Modifier = Modifier,
    currentSelectedPlace: Place?,
) {
    LazyColumn(
        modifier = modifier
            .padding(horizontal = 12.dp, vertical = 16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(placesList) {place ->
            PlacesListItem(
                place = place,
                onItemClick = { onItemClick(place) },
                selected = place == currentSelectedPlace,
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlacesListItem(
    place: Place,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit,
    selected: Boolean,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = if(selected)
            MaterialTheme.colorScheme.primaryContainer
            else
            MaterialTheme.colorScheme.secondaryContainer
        ),
        onClick = onItemClick
    ) {
        Row(
            modifier = Modifier.padding(20.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box {
                Image(
                    painter = painterResource(id = place.imageId),
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    stringResource(id = place.name),
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontSize = 20.sp
                    ),
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(bottom = 8.dp)
                    )
                Text(
                    "Rating: ${place.rating} / 5",
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontSize = 14.sp
                    ),
                    color = MaterialTheme.colorScheme.outline
                    )
            }
        }
    }
}

@Composable
fun PlaceDetail(
    place: Place?,
    modifier: Modifier = Modifier
) {
    if(place == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
            ) {
            Text("No place selected yet")
        }
    }
    else {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(start = 12.dp, end = 12.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Box {
                Image(
                    painter = painterResource(id = place.imageId),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1.5f),
                    contentScale = ContentScale.FillBounds
                )
            }
            Text(
                text = "Rating: ${place.rating} / 5",
                style = MaterialTheme.typography.headlineSmall
            )
            Column {
                Text(
                    "Description",
                    style = MaterialTheme.typography.headlineSmall,
                    textDecoration = TextDecoration.Underline
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    stringResource(id = place.description),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Text(
                "Check out menu",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.inversePrimary
                ),
                textDecoration = TextDecoration.Underline
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun PlaceListAndDetail(
    placesList: List<Place>,
    onItemClick: (Place) -> Unit,
    modifier: Modifier = Modifier,
    currentSelectedPlace: Place?,
) {
    Row(
        modifier = modifier.fillMaxSize()
    ) {
        PlacesList(
            placesList = placesList,
            modifier = Modifier.weight(1f),
            onItemClick = onItemClick,
            currentSelectedPlace = currentSelectedPlace
        )
        PlaceDetail(
            place = currentSelectedPlace,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview
@Composable
fun PlaceListItemPreview() {
    PlacesListItem(
        place = LocalPlacesDataProvider.allPlaces[0],
        onItemClick = { /*TODO*/ },
        selected = false,
    )
}

@Preview(showBackground = true)
@Composable
fun PlacesListPreview() {
    PlacesList(
        placesList = LocalPlacesDataProvider.allPlaces,
        currentSelectedPlace = null,
        onItemClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun PlaceDetailPreview() {
    PlaceDetail(
        place = LocalPlacesDataProvider.allPlaces[0]
    )
}

@Preview(showBackground = true, widthDp = 1000)
@Composable
fun PlacesListAndDetailPreview() {
    PlaceListAndDetail(
        placesList = LocalPlacesDataProvider.allPlaces,
        onItemClick = {},
        currentSelectedPlace = null
    )
}