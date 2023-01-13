package com.app.mentoriaandroid.features.home.data.repository

import com.app.mentoriaandroid.features.home.data.datasource.GetCharacterRemoteDataSource
import com.app.mentoriaandroid.features.home.domain.model.InfoCharacters
import com.app.mentoriaandroid.features.home.domain.repository.GetCharacterRepository

internal class GetCharacterRepositoryImpl(private val dataSource: GetCharacterRemoteDataSource) :
    GetCharacterRepository {
    override suspend fun getCharacters(): Result<List<InfoCharacters>> = dataSource.getCharacter()
}