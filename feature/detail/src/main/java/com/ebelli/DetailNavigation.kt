package com.ebelli

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.ebelli.utils.fromJson

const val detailNavigationRoute = "detail_route"

fun NavController.navigateToDetail(navOptions: NavOptions? = null, characterDetail: String) {
    this.navigate(detailNavigationRoute.plus("?characterDetail=${characterDetail}"), navOptions)
}

fun NavGraphBuilder.detailScreen(onBackClicked: () -> Unit) {
    composable(
        route = detailNavigationRoute.plus(
            "?characterDetail={characterDetail}"
        )
    ) {
        DetailScreen(
            it.arguments?.getString("characterDetail")?.fromJson<com.ebelli.model.Character>(),
            onBackButtonClicked = onBackClicked
        )
    }
}