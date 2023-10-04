package com.ebelli

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ebelli.component.CharacterItem
import com.ebelli.model.Character


@Composable
fun FavoritesScreen(favoriteViewModel: FavoriteViewModel, onItemClicked: (Character) -> Unit) {
    favoriteViewModel.getFavoriteList()
    val viewState = favoriteViewModel.viewState.collectAsState().value
    val favorites = viewState.favoriteList
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 5.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            favorites?.let { characters ->
                items(items = characters) { character ->
                    CharacterItem(character = character,
                        isFavoriteItem = false,
                        onItemClicked = {
                            onItemClicked.invoke(it)
                        }
                    )
                }
            }
        }
    }
}


@Preview(
    showBackground = true, name = "Light Mode"
)
@Preview(
    showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark Mode"
)
@Composable
fun DetailContentItemViewPreview() {
}
