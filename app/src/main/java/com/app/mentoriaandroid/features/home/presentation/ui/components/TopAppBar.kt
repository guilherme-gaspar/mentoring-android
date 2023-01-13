package com.app.mentoriaandroid.features.home.presentation.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun CharacterTopBar(
    navController: NavController
) {
    TopAppBar(
        elevation = 1.dp,
        title = {},
        backgroundColor = Color.White,
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(Icons.Filled.Share, null)
            }
        }, actions = {
            IconButton(onClick = { }) {
                Icon(Icons.Filled.Settings, null)
            }
        })
}
