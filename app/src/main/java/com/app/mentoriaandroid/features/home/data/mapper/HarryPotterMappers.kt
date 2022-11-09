package com.app.mentoriaandroid.features.home.data.mapper

import com.app.mentoriaandroid.features.home.data.model.InfoCharactersResponse
import com.app.mentoriaandroid.features.home.domain.model.InfoCharacters
import com.app.mentoriaandroid.features.home.domain.model.Wand

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