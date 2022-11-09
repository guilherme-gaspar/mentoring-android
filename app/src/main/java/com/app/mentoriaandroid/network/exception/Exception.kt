package com.app.mentoriaandroid.network.exception

data class InternetConnectionException(
    val errorMessage: String
) : Exception(errorMessage)

data class InternalServerException(
    val errorMessage: String
) : Exception(errorMessage)