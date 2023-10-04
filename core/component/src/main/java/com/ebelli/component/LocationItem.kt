package com.ebelli.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ebelli.model.LocationResponse

@Composable
fun LocationItem(item: LocationResponse, onClick: (LocationResponse) -> Unit) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color = if (item.isFavorite) Color.Blue else Color.Gray)
            .border(
                border = BorderStroke(2.dp, Color.Cyan),
                shape = RoundedCornerShape(10.dp)
            )
            .padding(12.dp)
            .clickable { onClick.invoke(item) }
    ) {
        Text(text = item.name, color = if (item.isFavorite) Color.White else Color.Black)
    }
}