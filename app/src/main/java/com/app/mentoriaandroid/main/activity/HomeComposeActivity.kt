package com.app.mentoriaandroid.main.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.mentoriaandroid.features.detail.presentation.viewmodel.DetailViewModel
import com.app.mentoriaandroid.features.home.domain.model.InfoCharacters
import com.app.mentoriaandroid.features.home.domain.model.Wand
import com.app.mentoriaandroid.features.home.presentation.model.HomeEvent
import com.app.mentoriaandroid.features.home.presentation.ui.components.CharacterList
import com.app.mentoriaandroid.features.home.presentation.ui.components.CharacterTopBar
import com.app.mentoriaandroid.features.home.presentation.viewmodel.HomeViewModel
import com.app.mentoriaandroid.features.navigation.navgraph.NavGraph
import com.app.mentoriaandroid.features.navigation.screen.Screen
import org.koin.androidx.viewmodel.ext.android.viewModel

val PADDING = 8.dp

class HomeComposeActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModel()
    private val detailViewModel: DetailViewModel by viewModel()
    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            setupObserverEvents()
            navController = rememberNavController()
            Column {
                CharacterTopBar(navController)
                NavGraph(
                    navController = navController,
                    homeViewModel = homeViewModel,
                    detailViewModel = detailViewModel
                )
            }
        }
    }

    @Composable
    internal fun setupObserverEvents() {
        when (val event = homeViewModel.eventLiveData.collectAsState(initial = null).value) {
            is HomeEvent.GoToDetail -> {
                navController.navigate(route = Screen.CharacterDetails.passCharacterId(event.infoCharacters))
            }
            is HomeEvent.ShowMessage -> {

            }
            else -> {}
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
            ),
            {}
        )
    }
}
