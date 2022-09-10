package com.app.mentoriaandroid.domain.repository

import com.app.mentoriaandroid.domain.Characters

internal interface GetCharacterRepository {

    suspend fun getCharacters(): Result<Characters>
}