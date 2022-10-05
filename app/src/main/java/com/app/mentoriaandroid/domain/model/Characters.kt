package com.app.mentoriaandroid.domain.model

data class InfoCharacters(
        val name: String,
        val species: String,
        val house: String,
        val dateOfBirth: String,
        val wizard: Boolean,
        val wand: Wand,
        val patronus: String,
        val actor: String,
        val image: String,
        var visibilityButton: Boolean = true
)

data class Wand(
        val wood: String,
        val core: String,
)