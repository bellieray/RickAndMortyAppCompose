package com.ebelli.navigation

import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ebelli.FavoriteViewModel
import com.ebelli.FavoritesScreen

const val favoritesNavigationRoute = "favorites_route"

fun NavController.navigateToFavorites(navOptions: NavOptions? = null) {
    this.navigate(favoritesNavigationRoute, navOptions)
}

fun NavGraphBuilder.favoritesScreen(
    onItemClicked: (com.ebelli.model.Character) -> Unit,
    navController: NavHostController
) {
    composable(favoritesNavigationRoute) { backStackEntry ->
        val parentEntry = remember(backStackEntry) {
            navController.getBackStackEntry(favoritesNavigationRoute)
        }
        val parentViewModel = hiltViewModel<FavoriteViewModel>(parentEntry)
        FavoritesScreen(
            parentViewModel
        ) {
            onItemClicked.invoke(it)
        }
    }
}