package com.app.mentoriaandroid.features.home.navigation

import android.content.Context
import android.content.Intent
import com.app.mentoriaandroid.features.home.presentation.ui.activity.HomeComposeActivity
import com.app.mentoriaandroid.navigation.home.HomeNavigation

class HomeNavigationImpl : HomeNavigation {
    override fun navigateToHome(context: Context) {
        context.startActivity(Intent(context, HomeComposeActivity::class.java))
    }
}