package com.app.mentoriaandroid.data.repository

import com.app.mentoriaandroid.data.datasource.GetCharacterRemoteDataSource
import com.app.mentoriaandroid.domain.model.InfoCharacters
import com.app.mentoriaandroid.domain.repository.GetCharacterRepository

internal class GetCharacterRepositoryImpl(private val dataSource: GetCharacterRemoteDataSource) :
    GetCharacterRepository {
    override suspend fun getCharacters(): Result<List<InfoCharacters>> = dataSource.getCharacter()
}