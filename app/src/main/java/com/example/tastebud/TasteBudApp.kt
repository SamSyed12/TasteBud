package com.example.tastebud

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TasteBudApp : Application() {
    val appViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(this).create(AppViewModel::class.java)
}


