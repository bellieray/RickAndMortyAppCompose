package com.ebelli.rickyandmortyappcompose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import androidx.tracing.trace
import com.ebelli.component.RickAndMortyScaffold
import com.ebelli.component.RickyAndMortyBar
import com.ebelli.component.RickyAndMortyBarItem
import com.ebelli.detailScreen
import com.ebelli.navigateToDetail
import com.ebelli.navigation.*
import com.ebelli.utils.toJson
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun RickyAndMortyNavHost() {
    val navController = rememberAnimatedNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    RickAndMortyScaffold(
        bottomBar = {
            RickyAndMortyBottomBar(
                destinations = BottomNavBar.values().toList(),
                onNavigateToDestination = ::navigateToBottomNavDestination,
                currentDestination = currentDestination,
                navController = navController
            )
        },
        content = { innerPadding ->
            AnimatedNavHost(
                navController = navController,
                startDestination = charactersNavigationRoute,
                Modifier.padding(innerPadding)
            ) {
                charactersScreen { navController.navigateToDetail(characterDetail = it.toJson()) }
                detailScreen { navController.navigateUp() }
                searchScreen()
                favoritesScreen()
                locationScreen()
            }

        }
    )
}

@Composable
private fun RickyAndMortyBottomBar(
    destinations: List<BottomNavBar>,
    onNavigateToDestination: (BottomNavBar, navController: NavController) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    RickyAndMortyBar(
        modifier = modifier,
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isBottomNavDestinationInHierarchy(destination)
            RickyAndMortyBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination, navController) },
                icon = {
                    Icon(
                        imageVector = destination.unselectedIcon,
                        contentDescription = null,
                    )
                },
                selectedIcon = {
                    Icon(
                        imageVector = destination.selectedIcon,
                        contentDescription = null,
                    )
                },
                label = { Text(stringResource(destination.iconTextId)) },
                modifier = Modifier,
            )
        }
    }
}


private fun NavDestination?.isBottomNavDestinationInHierarchy(destination: BottomNavBar) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false

fun navigateToBottomNavDestination(bottomNavBar: BottomNavBar, navController: NavController) {
    trace("Navigation: ${bottomNavBar.name}") {
        val bottomNavOptions = navOptions {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }

        when (bottomNavBar) {
            BottomNavBar.CHARACTERS -> navController.navigateToCharacter(bottomNavOptions)
            BottomNavBar.FAVORITES -> navController.navigateToFavorites(bottomNavOptions)
            BottomNavBar.LOCATION -> navController.navigateToLocation(bottomNavOptions)
            BottomNavBar.SEARCH -> navController.navigateToSearch(bottomNavOptions)
        }
    }
}