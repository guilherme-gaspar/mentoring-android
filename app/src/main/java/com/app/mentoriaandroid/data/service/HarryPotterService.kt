package com.app.mentoriaandroid.data.service

import com.app.mentoriaandroid.data.model.CharactersResponse
import retrofit2.http.GET

interface HarryPotterService {

    @GET("/characters")
    suspend fun getCharacters(): Result<CharactersResponse>

    @GET("/characters/students")
    fun getCharactersStudents()
}