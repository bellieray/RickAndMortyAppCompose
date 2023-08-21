package com.ebelli.navigation

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ebelli.component.RickAndMortyScaffold
import org.w3c.dom.CharacterData


@Composable
fun FavoritesScreen(

) {
    val scaffoldState = rememberScaffoldState()
  //  val viewState = viewModel.viewState.collectAsState().value

    RickAndMortyScaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        content = {
            Text(text = "Merhaba", modifier = Modifier.fillMaxSize(), color = Color.Cyan)
        }
    )
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
fun DetailContentItemViewPreview() {}
