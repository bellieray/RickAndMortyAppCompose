package com.ebelli.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ebelli.SearchScreen

const val searchNavigationRoute = "search_route"

fun NavController.navigateToSearch(navOptions: NavOptions? = null) {
    this.navigate(searchNavigationRoute, navOptions)
}

fun NavGraphBuilder.searchScreen(onItemClicked : (com.ebelli.model.Character) -> Unit) {
    composable(searchNavigationRoute) {
        SearchScreen(hiltViewModel(), onItemClicked)
    }
}