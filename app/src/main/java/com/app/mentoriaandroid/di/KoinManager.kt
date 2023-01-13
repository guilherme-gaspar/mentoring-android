package com.app.mentoriaandroid.di

import com.app.mentoriaandroid.features.home.di.harryPotterModules
import com.example.data.di.getNetworkModule
import org.koin.core.module.Module

object KoinManager {
    fun loadAllModules(): List<Module> {
        return listOf(
           harryPotterModules(),getNetworkModule()
        )
    }
}