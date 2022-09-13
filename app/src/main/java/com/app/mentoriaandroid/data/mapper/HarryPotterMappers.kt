package com.app.mentoriaandroid.data.mapper

import com.app.mentoriaandroid.data.model.InfoCharactersResponse
import com.app.mentoriaandroid.data.model.WandResponse
import com.app.mentoriaandroid.domain.model.InfoCharacters

internal fun InfoCharactersResponse.map() =
    InfoCharacters(
        name = name,
        species = species,
        house = house,
        dateOfBirth = dateOfBirth,
        yearOfBirth = yearOfBirth,
        wizard = wizard,
        wand = WandResponse(
            wood = wand.wood,
            core = wand.core,
            length = wand.length
        ),
        patronus = patronus,
        actor = actor,
        image = image
    )