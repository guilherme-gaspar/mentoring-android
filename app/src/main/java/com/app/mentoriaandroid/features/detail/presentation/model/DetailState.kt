package com.app.mentoriaandroid.features.detail.presentation.model

import com.app.mentoriaandroid.R
import com.app.mentoriaandroid.features.home.domain.model.InfoCharacters

data class DetailState(
    var text: String = "Hello State",
    var errorText: Int = R.string.message_error_default,
    var loading: Boolean = false,
) {

    fun showScreenErrorInternet(messageTest: Int = R.string.message_error_default) =
        this.apply {
            loading = false
            errorText = messageTest
        }
}