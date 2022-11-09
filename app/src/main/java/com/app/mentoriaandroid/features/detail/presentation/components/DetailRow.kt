package com.app.mentoriaandroid.features.detail.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.app.mentoriaandroid.features.home.presentation.ui.activity.PADDING

@Composable
fun DetailRow() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PADDING),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Hello world")
        }

    }
}