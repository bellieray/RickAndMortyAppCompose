package com.ebelli.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val charactersNavigationRoute = "characters_route"

fun NavController.navigateToCharacter(navOptions: NavOptions? = null) {
    this.navigate(charactersNavigationRoute, navOptions)
}

fun NavGraphBuilder.charactersScreen(navigateToDetail: (CharacterDto?) -> Unit) {
    composable(charactersNavigationRoute) {
        CharactersScreen(
            hiltViewModel(),
            navigateToDetail = {
                navigateToDetail.invoke(it)
            }
        )
    }
}