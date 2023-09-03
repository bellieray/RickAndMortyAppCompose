package com.ebelli.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ebelli.CharactersScreen
import org.w3c.dom.CharacterData

const val charactersNavigationRoute = "characters_route"

fun NavHostController.navigateToCharacter(navOptions: NavOptions? = null) {
    navigate(charactersNavigationRoute, navOptions)
}

fun NavGraphBuilder.charactersScreen(onItemClicked: (com.ebelli.model.Character?) -> Unit) =
    composable(route = charactersNavigationRoute) {
        CharactersScreen(
            hiltViewModel(),
            onItemClicked = {
                onItemClicked.invoke(it)
            }
        )
    }
