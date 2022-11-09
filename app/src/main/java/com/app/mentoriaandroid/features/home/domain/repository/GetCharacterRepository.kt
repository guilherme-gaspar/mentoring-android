package com.app.mentoriaandroid.features.home.domain.repository

import com.app.mentoriaandroid.features.home.domain.model.InfoCharacters

internal interface GetCharacterRepository {

    suspend fun getCharacters(): Result<List<InfoCharacters>>
}