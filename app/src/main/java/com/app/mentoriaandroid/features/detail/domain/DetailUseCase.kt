package com.app.mentoriaandroid.features.detail.domain

import com.app.mentoriaandroid.R

internal class DetailUseCase {

    suspend operator fun invoke(): Result<String> {
        return Result.success("Hello")
    }
}