package com.app.mentoriaandroid.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.app.mentoriaandroid.domain.model.InfoCharacters
import com.app.mentoriaandroid.domain.model.Wand
import com.app.mentoriaandroid.presentation.home.HomeViewModel
import com.app.mentoriaandroid.presentation.home.RoundCornerImageView
import org.koin.androidx.viewmodel.ext.android.viewModel

val PADDING = 8.dp

class MainActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CharacterScreen()
        }
    }

    @Preview
    @Composable
    fun PreviewGreeting() {
        CharacterList(
            charactersList = mutableListOf(
                InfoCharacters(
                    "Harry Potter",
                    "teste 1",
                    "grifinólia",
                    "12/07",
                    true,
                    Wand(
                        "teste",
                        "teste"
                    ),
                    "patronus",
                    "Testando...",
                    "https://portalpopline.com.br/wp-content/uploads/2022/08/harry-potter-serie.jpg"
                )
            )
        )
    }

    @Composable
    private fun CharacterRow(
            infoCharacters: InfoCharacters,
            onEventClicked: (InfoCharacters) -> Unit
    ) {
        Column {
            Row(
                modifier = Modifier
                    .clickable(onClick = { onEventClicked(infoCharacters) })
                    .fillMaxWidth()
                    .padding(PADDING),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(top = 24.dp, start = 16.dp)
                ) {
                    RoundCornerImageView(
                        painter = rememberImagePainter(data = infoCharacters.image),
                        size = 100.dp,
                    )
                }

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(top = 24.dp, start = 16.dp)
                ) {
                    Text(
                        text = infoCharacters.name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = infoCharacters.actor,
                        fontSize = 12.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }

            }
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end = 24.dp, start = 24.dp)
            ) {
                AnimatedVisibility(visible =  viewModel.stateLiveData.value.listCharacter.get(0).visibilityButton?: true) {
                    Button(
                        onClick = {
                            viewModel.changeVisibility()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        content = {
                            Text(text = "clicar")
                        }
                    )
                }

            }
        }
    }

    @Composable
    private fun CharacterList(charactersList: List<InfoCharacters>) {
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items = charactersList) {
                CharacterRow(infoCharacters = it, onEventClicked = {
                    Toast.makeText(this@MainActivity, "click", Toast.LENGTH_SHORT).show()
                })
            }
        }
    }

    @Composable
    internal fun CharacterScreen() {
        val state = viewModel.stateLiveData.collectAsState()
        CharacterList(charactersList = state.value.listCharacter)
    }
}
