package com.app.mentoriaandroid.features.detail.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.app.mentoriaandroid.databinding.ActivityHomeBinding
import com.app.mentoriaandroid.features.home.presentation.model.HomeState
import com.app.mentoriaandroid.features.home.presentation.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel()
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupScreen()
        setupObserver()
    }

    private fun setupScreen() {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setupObserver() {
        lifecycleScope.launchWhenResumed {
            viewModel.stateLiveData.collectLatest { state ->
                setupUi(state)
            }
        }
    }

    private fun setupUi(state: HomeState) {
    }
}