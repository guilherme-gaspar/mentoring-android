package com.app.mentoriaandroid.features.home.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.mentoriaandroid.features.home.domain.usecase.GetCharacterUseCase
import com.app.mentoriaandroid.features.home.presentation.model.HomeEvent
import com.app.mentoriaandroid.features.home.presentation.model.HomeState
import com.app.mentoriaandroid.network.exception.InternetConnectionException
import com.app.mentoriaandroid.util.SingleLiveEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class HomeViewModel(private val homeUseCase: GetCharacterUseCase) : ViewModel() {

    private var _stateLiveData = MutableStateFlow(HomeState())
    val stateLiveData: StateFlow<HomeState> = _stateLiveData

    private val _eventLiveData = SingleLiveEvent<HomeEvent>()
    val eventLiveData: LiveData<HomeEvent> get() = _eventLiveData

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

    fun navigateToDetail() {
        HomeEvent.GoToDetail
    }

    private fun HomeEvent.run() {
        _eventLiveData.postValue(this)
    }
}