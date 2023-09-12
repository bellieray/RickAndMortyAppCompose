package com.ebelli.navigation

import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ebelli.CharactersScreen
import com.ebelli.FavoriteViewModel

const val charactersNavigationRoute = "characters_route"

fun NavHostController.navigateToCharacter(navOptions: NavOptions? = null) {
    navigate(charactersNavigationRoute, navOptions)
}

fun NavGraphBuilder.charactersScreen(
    onItemClicked: (com.ebelli.model.Character?) -> Unit,
    navController: NavHostController
) =
    composable(route = charactersNavigationRoute) { backStackEntry ->
        val parentEntry = remember(backStackEntry) {
            navController.getBackStackEntry(charactersNavigationRoute)
        }
        val parentViewModel = hiltViewModel<FavoriteViewModel>(parentEntry)
        CharactersScreen(
            hiltViewModel(),
            parentViewModel,
            onItemClicked = {
                onItemClicked.invoke(it)
            }
        )
    }
