package com.ebelli.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ebelli.LocationScreen

const val locationNavigationRoute = "location_route"

fun NavController.navigateToLocation(navOptions: NavOptions? = null) {
    this.navigate(locationNavigationRoute, navOptions)
}

fun NavGraphBuilder.locationScreen() {
    composable(locationNavigationRoute) {
        LocationScreen()
    }
}