package com.app.mentoriaandroid.features.home.presentation.model

internal sealed class HomeEvent {
    object GoToDetail : HomeEvent()
    data class ShowMessage(val idMessage: Int) : HomeEvent()
}