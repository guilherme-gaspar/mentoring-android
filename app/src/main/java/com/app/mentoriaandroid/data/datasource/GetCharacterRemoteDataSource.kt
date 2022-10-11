package com.app.mentoriaandroid.data.datasource

import com.app.mentoriaandroid.domain.model.InfoCharacters

interface GetCharacterRemoteDataSource {

    suspend fun getCharacter(): Result<List<InfoCharacters>>
}