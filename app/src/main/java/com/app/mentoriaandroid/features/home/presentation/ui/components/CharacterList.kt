package com.app.mentoriaandroid.features.home.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.mentoriaandroid.features.home.domain.model.InfoCharacters

@Composable
fun CharacterList(charactersList: List<InfoCharacters>, onEventClicked: (InfoCharacters) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(items = charactersList) { it ->
            CharacterRow(infoCharacters = it, onEventClicked = { infoCharacter ->
                onEventClicked.invoke(infoCharacter)
            })
        }
    }
}