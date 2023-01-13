package com.app.mentoriaandroid.features.detail.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.mentoriaandroid.features.detail.domain.DetailUseCase
import com.app.mentoriaandroid.features.detail.presentation.model.DetailState
import com.app.mentoriaandroid.network.exception.InternetConnectionException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class DetailViewModel(private val detailUseCase: DetailUseCase) : ViewModel() {

    private var _stateLiveData = MutableStateFlow(DetailState())
    val stateLiveData: StateFlow<DetailState> = _stateLiveData


    private fun setMessage() = viewModelScope.launch {
        detailUseCase.invoke().onSuccess { text ->
            _stateLiveData.value = DetailState(text = text)
        }.onFailure {
            handleError(it)
        }
    }

    private fun handleError(error: Throwable) {
        when (error) {
            is InternetConnectionException -> {
                _stateLiveData.value.showScreenErrorInternet()
            }
            else -> {}
        }
    }
}