package com.app.mentoriaandroid.data.mapper

import com.app.mentoriaandroid.data.model.InfoCharactersResponse
import com.app.mentoriaandroid.domain.model.InfoCharacters
import com.app.mentoriaandroid.domain.model.Wand

internal fun InfoCharactersResponse.map() =
    InfoCharacters(
        name = name,
        species = species,
        house = house,
        dateOfBirth = dateOfBirth,
        wizard = wizard,
        wand = Wand(
            wood = wand.wood,
            core = wand.core
        ),
        patronus = patronus,
        actor = actor,
        image = image,
    )