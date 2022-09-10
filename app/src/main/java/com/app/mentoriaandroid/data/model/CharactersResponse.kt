package com.app.mentoriaandroid.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharactersResponse(
        @SerializedName("name")
        val name: String,
        @SerializedName("species")
        val species: String,
        @SerializedName("house")
        val house: String,
        @SerializedName("dateOfBirth")
        val dateOfBirth: String,
        @SerializedName("yearOfBirth")
        val yearOfBirth: String,
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
) : Parcelable

@Parcelize
data class WandResponse(
        @SerializedName("wood")
        val wood: String,
        @SerializedName("wood")
        val core: String,
        @SerializedName("length")
        val length: Int
) : Parcelable
