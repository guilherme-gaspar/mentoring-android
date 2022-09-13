package com.app.mentoriaandroid.data.datasource

import com.app.mentoriaandroid.data.mapper.map
import com.app.mentoriaandroid.data.service.HarryPotterService
import com.app.mentoriaandroid.domain.model.InfoCharacters

internal class GetCharacterRemoteDataSourceImpl(private val harryPotterService: HarryPotterService) :
    GetCharacterRemoteDataSource {
    override suspend fun getCharacter(): Result<List<InfoCharacters>> =
        harryPotterService.getCharacters().map {
            it.map { response ->
                response.map()
            }
        }
}