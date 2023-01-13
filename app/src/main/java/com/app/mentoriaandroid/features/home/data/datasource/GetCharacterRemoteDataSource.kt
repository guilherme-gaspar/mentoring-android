package com.app.mentoriaandroid.features.home.data.datasource

import com.app.mentoriaandroid.features.home.domain.model.InfoCharacters

interface GetCharacterRemoteDataSource {

    suspend fun getCharacter(): Result<List<InfoCharacters>>
}