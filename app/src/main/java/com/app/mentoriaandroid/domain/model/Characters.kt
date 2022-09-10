package com.app.mentoriaandroid.domain

import com.app.mentoriaandroid.data.model.WandResponse

data class Characters(
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