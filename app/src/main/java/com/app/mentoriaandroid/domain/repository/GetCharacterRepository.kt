package com.app.mentoriaandroid.domain.repository

import com.app.mentoriaandroid.domain.model.InfoCharacters

internal interface GetCharacterRepository {

    suspend fun getCharacters(): Result<List<InfoCharacters>>
}