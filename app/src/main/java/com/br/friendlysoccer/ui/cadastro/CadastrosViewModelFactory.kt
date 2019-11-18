package com.br.friendlysoccer.ui.cadastro

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.br.friendlysoccer.data.repository.FirebaseRepository

class CadastrosViewModelFactory(
    private val repo: FirebaseRepository,
    private val application: Application
) :
    ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CadastroViewModel::class.java)) {
            return CadastroViewModel(repo,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}