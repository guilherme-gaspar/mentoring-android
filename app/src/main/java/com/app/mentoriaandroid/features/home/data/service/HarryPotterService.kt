package com.app.mentoriaandroid.features.home.data.service

import com.app.mentoriaandroid.features.home.data.model.InfoCharactersResponse
import retrofit2.http.GET

interface HarryPotterService {

    @GET("api/characters")
    suspend fun getCharacters(): List<InfoCharactersResponse>
}