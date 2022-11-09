package com.app.mentoriaandroid.features.detail.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.mentoriaandroid.features.detail.presentation.screen.DetailScreen
import com.app.mentoriaandroid.features.home.presentation.ui.components.ToolbarHome
import com.app.mentoriaandroid.features.home.presentation.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

val PADDING = 8.dp

class HomeComposeActivity : ComponentActivity() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToolbarHome()
            DetailScreen()
        }
    }

    @Preview
    @Composable
    fun PreviewGreeting() {

    }
}
