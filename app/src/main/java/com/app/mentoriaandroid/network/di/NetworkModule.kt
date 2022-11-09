package com.app.mentoriaandroid.network.di

import com.app.mentoriaandroid.features.home.data.service.HarryPotterService
import com.app.mentoriaandroid.network.config.getInstance
import org.koin.dsl.module
import retrofit2.Retrofit

fun getNetworkModule() = module {
    single { getInstance() }
    factory { get<Retrofit>().create(HarryPotterService::class.java) }
}