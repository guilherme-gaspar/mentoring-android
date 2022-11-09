package com.app.mentoriaandroid.features.home.data.model

import com.google.gson.annotations.SerializedName

data class InfoCharactersResponse(
    @SerializedName("name")
        val name: String,
    @SerializedName("species")
        val species: String,
    @SerializedName("house")
        val house: String,
    @SerializedName("dateOfBirth")
        val dateOfBirth: String,
    @SerializedName("wizard")
        val wizard: Boolean,
    @SerializedName("wand")
        val wand: WandResponse,
    @SerializedName("patronus")
        val patronus: String,
    @SerializedName("actor")
        val actor: String,
    @SerializedName("image")
        val image: String
)

data class WandResponse(
        @SerializedName("wood")
        val wood: String,
        @SerializedName("wood")
        val core: String,
)
