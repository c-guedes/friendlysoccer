package com.br.friendlysoccer.ui.cadastro

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.br.friendlysoccer.data.repository.FirebaseRepository
import kotlinx.coroutines.*

class CadastroViewModel(private val repo: FirebaseRepository, application: Application) :
    AndroidViewModel(application) {
    val password: MutableLiveData<String> = MutableLiveData()
    val nameUser: MutableLiveData<String> = MutableLiveData()

    val array: MutableLiveData<ArrayList<String>> = MutableLiveData()


    val isLoading = ObservableBoolean(false)
    val context = getApplication<Application>().applicationContext
    private val _navigationCommand: MutableLiveData<String> = MutableLiveData()
    val navigationCommand: MutableLiveData<String> = _navigationCommand

    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    fun makeNewLogin() {
        uiScope.launch {
            withContext(Dispatchers.IO) {
                array.let {
                    Log.e("USER", it.value?.get(0).toString())
                    repo.makeNewUser(
                        it.value?.get(0).toString(),
                        it.value?.get(1).toString(),
                        it.value?.get(2).toString()
                    ).addOnSuccessListener { Log.e("USER", "CRIADO COM SUCESSO") }
                        .addOnFailureListener { exception ->
                            Log.e(
                                "USER",
                                exception.localizedMessage
                            )
                        }
                }
            }
        }
    }


}