package com.ebelli.navigation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.ebelli.model.Character

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CharacterItem(character: Character) {
    Row(
        modifier = Modifier.border(
            width = 1.dp,
            color = Color.Magenta,
            shape = RoundedCornerShape(10.dp)
        )
    ) {
        GlideImage(
            model = character.image,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .border(width = 1.dp, color = Color.Blue, shape = CircleShape),
            contentDescription = "image"
        )

        Spacer(modifier = Modifier.size(10.dp))

        Column {
            Text(text = character.name, color = Color.White, fontSize = 30.sp)
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = character.location.name, color = Color.White, fontSize = 20.sp)
        }
    }
}