package com.app.mentoriaandroid.data.excpetion

data class InternetConnectionException(
        val errorMessage: String
) : Exception(errorMessage)

data class InternalServerException(
        val errorMessage: String
) : Exception(errorMessage)