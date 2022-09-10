package com.app.mentoriaandroid.data.mapper

import com.app.mentoriaandroid.data.model.CharactersResponse
import com.app.mentoriaandroid.data.model.WandResponse
import com.app.mentoriaandroid.domain.Characters

internal fun CharactersResponse.map() =
    Characters(
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