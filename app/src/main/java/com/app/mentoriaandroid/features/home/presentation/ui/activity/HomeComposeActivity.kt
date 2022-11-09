package com.app.mentoriaandroid.features.home.presentation.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.app.mentoriaandroid.features.home.domain.model.InfoCharacters
import com.app.mentoriaandroid.features.home.domain.model.Wand
import com.app.mentoriaandroid.features.home.presentation.model.HomeEvent
import com.app.mentoriaandroid.features.home.presentation.ui.components.CharacterList
import com.app.mentoriaandroid.features.home.presentation.ui.components.ToolbarHome
import com.app.mentoriaandroid.features.home.presentation.ui.screen.CharacterScreen
import com.app.mentoriaandroid.features.home.presentation.viewmodel.HomeViewModel
import com.app.mentoriaandroid.navigation.detail.DetailNavigation
import kotlinx.coroutines.flow.collectLatest
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

val PADDING = 8.dp

class HomeComposeActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModel()
    private val detailNavigation: DetailNavigation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupObserver()
        setContent {
            ToolbarHome()
            CharacterScreen(viewModel)
        }
    }

    private fun setupObserver() {
        lifecycleScope.launchWhenResumed {
            viewModel.stateLiveData.collectLatest { state ->
            }
            viewModel.eventLiveData.observe(this@HomeComposeActivity) { event ->
                when (event) {
                    is HomeEvent.GoToDetail -> {
                        detailNavigation.navigateToDetail(this@HomeComposeActivity)
                    }
                    is HomeEvent.ShowMessage -> TODO()
                }
            }
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
