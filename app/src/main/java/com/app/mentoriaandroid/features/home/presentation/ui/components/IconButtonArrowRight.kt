package com.app.mentoriaandroid.features.home.presentation.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun IconArrowRight(
    imageVector: ImageVector = Icons.Filled.KeyboardArrowRight,
    contentDescription: String,
    tint: Color = Color.Blue,
    onEventClicked: () -> Unit
) {
    IconButton(
        onClick = {
            onEventClicked.invoke()
        }
    ) {
        Icon(
            imageVector = imageVector,
            modifier = Modifier
                .size(25.dp),
            contentDescription = contentDescription,
            tint = tint,
        )
    }
}