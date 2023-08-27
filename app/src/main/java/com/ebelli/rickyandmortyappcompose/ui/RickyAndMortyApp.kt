package com.ebelli.rickyandmortyappcompose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ebelli.component.RickAndMortyScaffold
import com.ebelli.rickyandmortyappcompose.navigation.BottomNavBar
import com.ebelli.rickyandmortyappcompose.navigation.RickyAndMortyBottomBar
import com.ebelli.rickyandmortyappcompose.navigation.RickyAndMortyNavHost
import com.ebelli.rickyandmortyappcompose.navigation.navigateToBottomNavDestination

@Composable
fun RickyAndMortyApp(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navController
        .currentBackStackEntryAsState().value?.destination
    Column {
        RickAndMortyScaffold(
            bottomBar = {
                RickyAndMortyBottomBar(
                    destinations = BottomNavBar.values().toList(),
                    onNavigateToDestination = ::navigateToBottomNavDestination,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        ) {
            RickyAndMortyNavHost(navController = navController, it)
        }
    }
}