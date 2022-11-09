package com.app.mentoriaandroid.features.home.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.app.mentoriaandroid.R

@Composable
fun RoundCornerImageView(
    painter: ImagePainter, size: Dp = 50.dp
) {
    Box {
        Image(
            painter = rememberImagePainter(R.drawable.circle_blue_shape),
            contentDescription = "Round corner image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(size)
                .clip(RoundedCornerShape(10f))
        )

        Image(
            painter = painter,
            contentDescription = "Round corner image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(size)
                .clip(RoundedCornerShape(24f))
        )
    }
}