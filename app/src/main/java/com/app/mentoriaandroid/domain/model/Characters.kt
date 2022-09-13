package com.app.mentoriaandroid.domain.model

import com.app.mentoriaandroid.data.model.WandResponse

data class InfoCharacters(
        val name: String,
        val species: String,
        val house: String,
        val dateOfBirth: String,
        val yearOfBirth: String,
        val wizard: Boolean,
        val wand: WandResponse,
        val patronus: String,
        val actor: String,
        val image: String
)

data class Wand(
        val wood: String,
        val core: String,
        val length: Int
)