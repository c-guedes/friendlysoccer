package com.br.friendlysoccer.ui.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.br.friendlysoccer.data.repository.FirebaseRepository

class HomeViewModelFactory(
    private val repo: FirebaseRepository,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repo, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}