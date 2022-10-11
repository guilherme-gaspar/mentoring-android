package com.app.mentoriaandroid.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.mentoriaandroid.data.excpetion.InternetConnectionException
import com.app.mentoriaandroid.domain.usecase.GetCharacterUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class HomeViewModel(private val homeUseCase: GetCharacterUseCase) : ViewModel() {

    private var _stateLiveData = MutableStateFlow(HomeState())
    val stateLiveData: StateFlow<HomeState> = _stateLiveData

    init {
        getCharacter()
    }

    private fun getCharacter() = viewModelScope.launch {
        homeUseCase.invoke().onSuccess { listInfo ->
            _stateLiveData.value = HomeState(listCharacter = listInfo)
        }.onFailure {
            handleError(it)
        }
    }

    private fun handleError(error: Throwable) {
        when (error) {
            is InternetConnectionException -> {
                _stateLiveData.value.showScreenErrorInternet()
            }
            else -> {
                _stateLiveData.value.showScreenErrorDefault()
            }
        }
    }

    fun changeVisibility() {
        _stateLiveData.value = stateLiveData.value.copy(
            listCharacter = _stateLiveData.value.listCharacter.map {
                it.visibilityButton = false
                it
            }
        )
    }
}