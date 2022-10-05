package com.app.mentoriaandroid.presentation.home

import com.app.mentoriaandroid.R
import com.app.mentoriaandroid.domain.model.InfoCharacters

data class HomeState(
        var listCharacter: List<InfoCharacters> = listOf(),
        var messageFooter: Int = R.string.message_error_default,
        var loading: Boolean = false,
) {

    fun showScreenErrorInternet(messageError: Int = R.string.without_connection_internet) =
        this.apply {
            loading = false
            messageFooter = messageError
        }

    fun showScreenErrorDefault(messageError: Int = R.string.message_error_default) = this.apply {
        loading = false
        messageFooter = messageError
    }
}