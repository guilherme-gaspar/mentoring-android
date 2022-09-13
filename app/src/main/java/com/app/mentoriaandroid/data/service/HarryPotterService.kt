package com.app.mentoriaandroid.data.service

import com.app.mentoriaandroid.data.model.InfoCharactersResponse
import retrofit2.http.GET

interface HarryPotterService {

    @GET("/characters")
    suspend fun getCharacters(): Result<List<InfoCharactersResponse>>
}