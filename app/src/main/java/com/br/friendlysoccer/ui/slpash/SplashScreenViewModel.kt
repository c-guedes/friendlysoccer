package com.br.friendlysoccer.ui.slpash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.delay

class SplashScreenViewModel (application: Application): AndroidViewModel(application){
    private var SPLASH_SCREEN_DELAY_MILLIS = 3000L
    private val _navigationCommand: MutableLiveData<String> = MutableLiveData()
    val navigationCommand: MutableLiveData<String> = _navigationCommand

    fun navigate(navigationRequest: String) {
        _navigationCommand.value = navigationRequest
//        uiScope.launch {
//
//        }
    }

    private val programStart = System.currentTimeMillis()

    suspend fun waitUntil(timeSinceStart: Long) {
        delay(SPLASH_SCREEN_DELAY_MILLIS)
    }


}