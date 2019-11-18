package com.br.friendlysoccer.ui.login

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.br.friendlysoccer.data.repository.FirebaseRepository

class LoginViewModelFactory(
    private val repo: FirebaseRepository,
                            private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repo,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}