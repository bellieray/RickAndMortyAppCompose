package com.ebelli

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ebelli.component.CharacterItem
import com.ebelli.component.LocationItem


@Composable
fun LocationScreen(
    locationViewModel: LocationViewModel,
    onItemClicked: (com.ebelli.model.Character) -> Unit
) {
    val viewState = locationViewModel.locationViewState.collectAsState().value
    Column(modifier = Modifier.padding(top = 20.dp)) {
        LazyRow(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            viewState.locations?.results?.let {
                items(items = it) { location ->
                    LocationItem(item = location) { item ->
                        locationViewModel.getByCharactersById(item.getIds())
                        locationViewModel.updateList(item.id)
                    }
                }
            }
        }

        viewState.characters?.takeIf { it.isNotEmpty() }?.let { characters ->
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(top = 10.dp)
            ) {
                items(items = characters) { character ->
                    CharacterItem(character = character,
                        onItemClicked = {
                            onItemClicked.invoke(it)
                        }
                    )
                }
            }
        } ?: run {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    text = "No Data Found",
                    color = Color.Gray,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        if (viewState.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White)
                    .padding(16.dp),
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.Center),
                    color = Color.Red
                )
            }
        }
    }

}

@Preview(
    showBackground = true,
    name = "Light Mode"
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode"
)
@Composable
fun DetailContentItemViewPreview() {
}
