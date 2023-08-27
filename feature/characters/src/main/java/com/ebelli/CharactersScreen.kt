package com.ebelli

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ebelli.navigation.CharacterItem
import org.w3c.dom.CharacterData

@Composable
fun CharactersScreen(
    viewModel: CharactersViewModel,
    onItemClicked: (CharacterData) -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val viewState = viewModel.viewState.collectAsState().value
    val characters = viewState.characters?.results

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Red)
        ) {
            LazyColumn(modifier = Modifier.background(color = Color.Yellow)) {
                characters?.let {
                    items(characters) { character ->
                        CharacterItem(character = character)
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
