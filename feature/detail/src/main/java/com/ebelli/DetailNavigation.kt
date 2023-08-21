package com.ebelli

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val detailNavigationRoute = "detail_route"

fun NavController.navigateToDetail(navOptions: NavOptions? = null, characterDetail: String) {
    this.navigate(detailNavigationRoute.plus("?characterDetail=${characterDetail}"), navOptions)
}

fun NavGraphBuilder.detailScreen(onBackClicked: () -> Unit) {
    composable(detailNavigationRoute) {
        DetailScreen()
    }
}