package com.app.mentoriaandroid.presentation

import com.app.mentoriaandroid.domain.model.InfoCharacters

sealed class HomeState {
    data class Success(val result: List<InfoCharacters>) : HomeState()
    data class Error(val exception: Throwable) : HomeState()
    object Loading : HomeState()
}