package com.ebelli.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RickAndMortyTitle(title: String) {
    Text(
        text = "${title}:",
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = 16.sp,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier.wrapContentSize()
    )
}

@Composable
fun RickAndMortyText(desc: String?) {
    Text(
        text = "$desc",
        color = Color.Gray,
        fontSize = 12.sp,
        modifier = Modifier
            .wrapContentSize()
            .padding(start = 5.dp)
    )
}
