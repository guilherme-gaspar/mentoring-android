package com.app.mentoriaandroid.domain.usecase

import com.app.mentoriaandroid.domain.model.InfoCharacters
import com.app.mentoriaandroid.domain.repository.GetCharacterRepository

internal class GetCharacterUseCase(private val repository: GetCharacterRepository) {
    suspend operator fun invoke(): Result<List<InfoCharacters>> {
        return repository.getCharacters()
    }
}