package com.ebelli.rickyandmortyappcompose.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.ebelli.icon.AppIcons
import com.ebelli.navigation.charactersNavigationRoute
import com.ebelli.navigation.favoritesNavigationRoute
import com.ebelli.navigation.locationNavigationRoute
import com.ebelli.navigation.searchNavigationRoute
import com.ebelli.characters.R as charactersR
import com.ebelli.favorites.R as favoritesR
import com.ebelli.location.R as locationR
import com.ebelli.search.R as searchR


enum class BottomNavBar(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int,
) {
    CHARACTERS(
        route = charactersNavigationRoute,
        selectedIcon = AppIcons.Character,
        unselectedIcon = AppIcons.CharacterBordered,
        iconTextId = charactersR.string.characters,
        titleTextId = charactersR.string.characters,
    ),
    FAVORITES(
        route = favoritesNavigationRoute,
        selectedIcon = AppIcons.Favorite,
        unselectedIcon = AppIcons.FavoriteBorder,
        iconTextId = favoritesR.string.favorites,
        titleTextId = favoritesR.string.favorites,
    ),
    SEARCH(
        route = searchNavigationRoute,
        selectedIcon = AppIcons.Search,
        unselectedIcon = AppIcons.SearchBorder,
        iconTextId = searchR.string.search,
        titleTextId = searchR.string.search,
    ),
    LOCATION(
        route = locationNavigationRoute,
        selectedIcon = AppIcons.Location,
        unselectedIcon = AppIcons.LocationBorder,
        iconTextId = locationR.string.location,
        titleTextId = locationR.string.location,
    )
}