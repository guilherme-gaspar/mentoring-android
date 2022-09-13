package com.app.mentoriaandroid.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.mentoriaandroid.data.excpetion.InternetConnectionException
import com.app.mentoriaandroid.domain.usecase.GetCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class HomeViewModel(private val homeUseCase: GetCharacterUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeState>(HomeState.Success(emptyList()))
    val uiState: StateFlow<HomeState> = _uiState

    fun getCharacter() = viewModelScope.launch {
        homeUseCase.invoke().onSuccess { listInfo ->
            _uiState.value = HomeState.Success(listInfo)
        }.onFailure {
            handleError(it)
        }
    }

    private fun handleError(error: Throwable) {
        when (error) {
            is InternetConnectionException -> {
                _uiState.value = HomeState.Error(error)
            }
            else -> {
            }
        }
    }
}