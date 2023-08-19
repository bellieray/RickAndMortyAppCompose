package com.ebelli.rickyandmortyappcompose.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import com.ebelli.theme.RickyAndMortyAppComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : androidx.activity.ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickyAndMortyAppComposeTheme() {
                RickyAndMortyApp()
            }
        }
    }
}