package com.app.mentoriaandroid.features.home.presentation.model

import com.app.mentoriaandroid.features.home.domain.model.InfoCharacters

internal sealed class HomeEvent {
    data class GoToDetail(val infoCharacters: InfoCharacters) : HomeEvent()
    data class ShowMessage(val idMessage: Int) : HomeEvent()
}