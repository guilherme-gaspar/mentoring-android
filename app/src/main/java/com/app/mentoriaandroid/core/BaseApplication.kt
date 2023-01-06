package com.app.mentoriaandroid.core

import android.app.Application
import com.app.mentoriaandroid.di.KoinManager
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseApplication)
            modules(KoinManager.loadAllModules())
        }
    }
}