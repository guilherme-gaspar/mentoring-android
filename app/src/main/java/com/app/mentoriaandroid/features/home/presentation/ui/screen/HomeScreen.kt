package com.app.mentoriaandroid.features.home.presentation.ui.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.app.mentoriaandroid.features.home.presentation.model.HomeEvent
import com.app.mentoriaandroid.features.home.presentation.viewmodel.HomeViewModel
import com.app.mentoriaandroid.features.home.presentation.ui.components.CharacterList

@Composable
internal fun HomeScreen(viewModel: HomeViewModel) {
    val context = LocalContext.current
    val state = viewModel.stateLiveData.collectAsState()
    CharacterList(
        charactersList = state.value.listCharacter,
        onEventClicked = {
            /*Toast.makeText(context, "click", Toast.LENGTH_SHORT).show()*/
            viewModel.navigateToDetail(it)
        }
    )
}