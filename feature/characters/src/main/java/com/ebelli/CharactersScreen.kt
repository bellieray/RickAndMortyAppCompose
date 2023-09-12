package com.ebelli

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.ebelli.component.CharacterItem

@Composable
fun CharactersScreen(
    charactersViewModel: CharactersViewModel,
    favoriteViewModel: FavoriteViewModel,
    onItemClicked: (com.ebelli.model.Character) -> Unit,
) {
    favoriteViewModel.getFavoriteList()
    val viewState = charactersViewModel.viewState.collectAsState().value
    val characters = viewState.characters
    val favorites = viewState.favorites
    val pagingItems: LazyPagingItems<com.ebelli.model.Character>? =
        characters?.collectAsLazyPagingItems()
    charactersViewModel.setFavorites(favoriteViewModel.viewState.value.favoriteList)

    pagingItems?.itemSnapshotList?.items?.map {
        it.isFavorite = favorites?.contains(it) == true
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.padding(horizontal = 5.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                characters?.let {
                    items(items = pagingItems!!) { character ->
                        CharacterItem(character = character!!,
                            onFavoriteClicked = { clickedCharacter ->
                                charactersViewModel.modifyFavorites(clickedCharacter)
                            },
                            onItemClicked = {
                                onItemClicked.invoke(it)
                            }
                        )
                    }
                    if (viewState.isLoading) {
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                CircularProgressIndicator(
                                    modifier = Modifier
                                        .size(32.dp),
                                    color = Color.Red
                                )
                            }
                        }
                    }
                }
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red)
    ) {
        LazyColumn(
            modifier = Modifier
                .background(color = Color.Yellow)
                .fillMaxWidth(),
            contentPadding = PaddingValues(5.dp)
        ) {
            items((0..10).toList()) { character ->
                Text(text = character.toString())
            }
        }
    }
}
