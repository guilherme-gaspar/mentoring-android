package com.app.mentoriaandroid.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.mentoriaandroid.R
import com.app.mentoriaandroid.navigation.home.HomeNavigation
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val homeNavigation: HomeNavigation by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeNavigation.navigateToHome(this)
    }
}