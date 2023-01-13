package com.app.mentoriaandroid.features.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.mentoriaandroid.features.home.domain.model.InfoCharacters
import com.app.mentoriaandroid.features.home.domain.usecase.GetCharacterUseCase
import com.app.mentoriaandroid.features.home.presentation.model.HomeEvent
import com.app.mentoriaandroid.features.home.presentation.model.HomeState
import com.app.mentoriaandroid.network.exception.InternetConnectionException
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

internal class HomeViewModel(private val homeUseCase: GetCharacterUseCase) : ViewModel() {

    private var _stateLiveData = MutableStateFlow(HomeState())
    val stateLiveData: StateFlow<HomeState> = _stateLiveData

    private val _eventLiveData = Channel<HomeEvent>(Channel.BUFFERED)
    val eventLiveData = _eventLiveData.receiveAsFlow()

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

    fun navigateToDetail(infoCharacters: InfoCharacters) {
        HomeEvent.GoToDetail(infoCharacters).run()
    }

    private fun HomeEvent.run() {
        val event = this
        viewModelScope.launch {
            _eventLiveData.send(event)
        }
    }
}