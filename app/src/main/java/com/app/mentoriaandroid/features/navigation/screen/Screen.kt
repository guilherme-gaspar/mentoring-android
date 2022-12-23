package com.app.mentoriaandroid.features.navigation.screen

import com.app.mentoriaandroid.features.home.domain.model.InfoCharacters

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object CharacterDetails : Screen("?detail_screen={infoCharacters}") {
        fun passCharacterId(infoCharacters: InfoCharacters) = "?detail_screen=/$infoCharacters"
    }
}
