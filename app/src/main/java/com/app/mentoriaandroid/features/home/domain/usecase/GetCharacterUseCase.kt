package com.app.mentoriaandroid.features.home.domain.usecase

import com.app.mentoriaandroid.features.home.domain.model.InfoCharacters
import com.app.mentoriaandroid.features.home.domain.repository.GetCharacterRepository

internal class GetCharacterUseCase(private val repository: GetCharacterRepository) {
    suspend operator fun invoke(): Result<List<InfoCharacters>> {
        return repository.getCharacters()
    }
}