package com.br.friendlysoccer.ui.login

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.br.friendlysoccer.data.model.User
import com.br.friendlysoccer.data.repository.FirebaseRepository
import kotlinx.coroutines.*

class LoginViewModel(
    private val repo: FirebaseRepository,
    application: Application
) : AndroidViewModel(application) {
    val password: MutableLiveData<String> = MutableLiveData()
    val nameUser: MutableLiveData<String> = MutableLiveData()
    val testezito = application.baseContext
    val context = getApplication<Application>().applicationContext
    val isLoading = ObservableBoolean(false)

    private val _navigationCommand: MutableLiveData<String> = MutableLiveData()
    val navigationCommand: MutableLiveData<String> = _navigationCommand


    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun doLogin() {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                val user = User(nameUser.value.toString(), password.value.toString())
                Log.e("USER", nameUser.value.toString() + password.value.toString() )
                user.let { repo.doSimpliedLogin(user).addOnSuccessListener { navigate("Teste2") }}
            }
        }
    }

    fun navigate(navigationRequest: String) {
        _navigationCommand.value = navigationRequest
//        uiScope.launch {
//
//        }
    }

    fun getUser() {
        uiScope.launch {
            Log.e("USER", repo.getUser().toString())
        }
    }


}