package com.ebelli.component

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.CrossFade
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.ebelli.model.Character

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CharacterItem(
    isFavoriteItem: Boolean = false,
    character: Character,
    onFavoriteClicked: (Character) -> Unit = {},
    onItemClicked: (Character) -> Unit
) {
    Row(
        modifier = Modifier
            .clickable { onItemClicked(character) }
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.Gray)
            .border(
                border = BorderStroke(2.dp, Color.Cyan),
                shape = RoundedCornerShape(10.dp)
            )
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            GlideImage(
                model = character.image,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .border(width = 1.dp, color = Color.Blue, shape = CircleShape),
                contentDescription = "image",
                transition = CrossFade
            )

            Spacer(modifier = Modifier.size(10.dp))

            Column(modifier = Modifier.wrapContentWidth()) {
                Text(
                    text = character.name,
                    color = Color.White,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Spacer(modifier = Modifier.size(10.dp))
                Text(
                    text = character.location.name,
                    color = Color.White,
                    fontSize = 12.sp,
                )
            }
        }
        if (isFavoriteItem.not()) {
            Box(contentAlignment = Alignment.TopEnd) {
                Image(
                    imageVector = if (character.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "",
                    modifier = Modifier
                        .clickable {
                            onFavoriteClicked(character)
                        })
            }
        }
    }
}
