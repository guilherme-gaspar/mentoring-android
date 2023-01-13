package com.app.mentoriaandroid.features.detail.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.app.mentoriaandroid.features.home.presentation.ui.components.CharacterTopBar
import com.app.mentoriaandroid.main.activity.PADDING

@Composable
fun DetailRow(text: String, navController: NavController) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PADDING),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text)
        }

    }
}