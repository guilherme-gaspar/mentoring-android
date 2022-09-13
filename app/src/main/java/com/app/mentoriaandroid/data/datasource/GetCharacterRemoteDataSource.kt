package com.app.mentoriaandroid.data.datasource

import com.app.mentoriaandroid.domain.model.Characters

interface GetCharacterRemoteDataSource {

    suspend fun getCharacter(): Result<Characters>
}