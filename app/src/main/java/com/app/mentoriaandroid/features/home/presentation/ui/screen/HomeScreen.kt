package com.app.mentoriaandroid.features.home.presentation.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.app.mentoriaandroid.features.home.domain.model.InfoCharacters
import com.app.mentoriaandroid.features.home.presentation.viewmodel.HomeViewModel
import com.app.mentoriaandroid.features.home.presentation.ui.components.CharacterList

@Composable
internal fun CharacterScreen(viewModel: HomeViewModel) {
    val state = viewModel.stateLiveData.collectAsState()
    CharacterList(
        charactersList = state.value.listCharacter,
        onEventClicked = {
            viewModel.navigateToDetail()
        }
    )
}