package com.app.mentoriaandroid.data.datasource

import com.app.mentoriaandroid.data.excpetion.InternalServerException
import com.app.mentoriaandroid.data.excpetion.InternetConnectionException
import com.app.mentoriaandroid.data.mapper.map
import com.app.mentoriaandroid.data.service.HarryPotterService
import com.app.mentoriaandroid.domain.Characters
import okio.IOException

internal class GetCharacterRemoteDataSourceImpl(private val harryPotterService: HarryPotterService) :
    GetCharacterRemoteDataSource {
    override suspend fun getCharacter(): Result<Characters> =
        harryPotterService.getCharacters().map { response ->
            response.map()
        }.recoverCatching { exception ->
            return Result.failure(
                when (exception) {
                    is IOException -> InternetConnectionException(exception.message.orEmpty())
                    else -> InternalServerException(exception.message.orEmpty())
                }
            )
        }
}