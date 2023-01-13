package com.app.mentoriaandroid.features.detail.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.app.mentoriaandroid.features.detail.presentation.ui.components.DetailRow
import com.app.mentoriaandroid.features.detail.presentation.viewmodel.DetailViewModel

@Composable
internal fun DetailScreen(viewModel: DetailViewModel, navController: NavController) {
    val state = viewModel.stateLiveData.collectAsState()
    DetailRow(state.value.text,navController)

}