package com.ebelli.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RowScope.RickyAndMortyBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit = icon,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true,
) {
    BottomNavigationItem(
        selected = selected,
        onClick = onClick,
        icon = {
            Box(
                modifier = Modifier
                    .background(
                        if (selected) Color.LightGray else Color.Transparent,
                        shape = RoundedCornerShape(7.dp)
                    )
                    .padding(4.dp)
            ) {
                if (selected) {
                    selectedIcon()
                } else {
                    icon()
                }
            }
        },
        modifier = if (!selected) modifier else modifier.background(
            color = Color.LightGray,
            shape = RoundedCornerShape(7.dp)
        ),
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        selectedContentColor = Color.White,
        unselectedContentColor = Color.Gray
    )
}

@Composable
fun RickyAndMortyBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.White,
        contentColor = Color.Magenta,
        content = content,
    )
}