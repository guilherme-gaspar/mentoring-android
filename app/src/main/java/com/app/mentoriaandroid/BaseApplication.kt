package com.app.mentoriaandroid

import android.app.Application
import com.app.mentoriaandroid.di.harryPotterModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseApplication)
            modules(harryPotterModules)
        }
    }
}