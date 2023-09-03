package com.ebelli

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.CrossFade
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.ebelli.component.RickAndMortyText
import com.ebelli.component.RickAndMortyTitle
import com.ebelli.model.Character


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailScreen(character: Character?, onBackButtonClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "arrowBack",
            modifier = Modifier
                .padding(top = 20.dp, start = 20.dp)
                .size(34.dp)
                .clickable { onBackButtonClicked.invoke() }
        )

        character?.let {
            GlideImage(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .align(Alignment.CenterHorizontally)
                    .size(300.dp),
                model = character.image,
                contentScale = ContentScale.Fit,
                contentDescription = "image",
                transition = CrossFade
            )
        }

        Card(
            modifier = Modifier
                .padding(top = 20.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp,
            border = BorderStroke(2.dp, color = Color.Black)
        ) {
            Column(
                Modifier.padding(top = 20.dp, bottom = 20.dp, start = 40.dp, end = 40.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RickAndMortyTitle(title = "Name")
                    RickAndMortyText(desc = character?.name)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RickAndMortyTitle(title = "Gender")
                    RickAndMortyText(desc = character?.gender)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RickAndMortyTitle(title = "Status")
                    RickAndMortyText(desc = character?.status)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RickAndMortyTitle(title = "Location")
                    RickAndMortyText(desc = character?.location?.name)
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    RickAndMortyTitle(title = "Species")
                    RickAndMortyText(desc = character?.species)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RickAndMortyTitle(title = "Created at")
                    RickAndMortyText(desc = character?.created)
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
    Row {
        Image(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "arrowBack",
            Modifier.size(34.dp)
        )
    }
}
