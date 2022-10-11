package com.app.mentoriaandroid.data.datasource

import com.app.mentoriaandroid.data.mapper.map
import com.app.mentoriaandroid.data.service.HarryPotterService
import com.app.mentoriaandroid.domain.model.InfoCharacters

internal class GetCharacterRemoteDataSourceImpl(private val harryPotterService: HarryPotterService) :
    GetCharacterRemoteDataSource {
    override suspend fun getCharacter(): Result<List<InfoCharacters>> {
        return try {
            Result.success(harryPotterService.getCharacters().map { response ->
                response.map()
            })
        } catch (exception: Exception) {
            Result.failure(exception)
            //Tratar aqui os erros possíveis
        }
    }
}