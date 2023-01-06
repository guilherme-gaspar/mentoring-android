package com.example.data.di

import com.example.data.config.getInstance
import org.koin.dsl.module

fun getNetworkModule() = module {
    single { getInstance() }
}