package com.ebelli.rickyandmortyappcompose.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ebelli.rickyandmortyappcompose.navigation.RickyAndMortyNavHost
import com.ebelli.theme.RickyAndMortyAppComposeTheme

@Composable
fun RickyAndMortyApp() {
    RickyAndMortyAppComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            RickyAndMortyNavHost()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickyAndMortyAppComposeTheme {
        RickyAndMortyNavHost()
    }
}