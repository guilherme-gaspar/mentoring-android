package com.app.mentoriaandroid.features.home.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.app.mentoriaandroid.features.home.domain.model.InfoCharacters
import com.app.mentoriaandroid.main.activity.PADDING

@Composable
fun CharacterRow(
    infoCharacters: InfoCharacters,
    onEventClicked: (InfoCharacters) -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .clickable { onEventClicked.invoke(infoCharacters) }
                .fillMaxWidth()
                .padding(PADDING),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(top = 24.dp, start = 16.dp)
                    .clickable { onEventClicked.invoke(infoCharacters) }
            ) {
                RoundCornerImageView(
                    painter = rememberImagePainter(data = infoCharacters.image),
                    size = 70.dp,
                )
            }
            TitleDescriptionComponent(
                title = infoCharacters.name,
                description = infoCharacters.actor
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconArrowRight(
                    contentDescription = "Ver detalhes",
                    onEventClicked = { onEventClicked.invoke(infoCharacters) })
            }
        }

    }
}