package com.br.friendlysoccer.ui.cadastro

import android.app.Application
import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.br.friendlysoccer.data.repository.FirebaseRepository
import kotlinx.coroutines.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class CadastroViewModel(private val repo: FirebaseRepository, application: Application) :
    AndroidViewModel(application) {
    val displayName: MutableLiveData<String> = MutableLiveData()
    val userEmail: MutableLiveData<String> = MutableLiveData()
    val userPassConf: MutableLiveData<String> = MutableLiveData()


    val isLoading = ObservableBoolean(false)
    val context = getApplication<Application>().applicationContext
    private val _navigationCommand: MutableLiveData<String> = MutableLiveData()
    val navigationCommand: MutableLiveData<String> = _navigationCommand

    val userPass: MutableLiveData<String> = MutableLiveData()
    fun getPass(): LiveData<String> {
        return userPass
    }

    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)


    fun makeNewLogin() {
       // require(userPass.value.toString() == userPassConf.value.toString()) {
            uiScope.launch {
                withContext(Dispatchers.IO) {
                    repo.makeNewUser(
                        displayName.value.toString(),
                        userEmail.value.toString(),
                        userPass.value.toString()
                    ).addOnSuccessListener { Log.e("USER", "CRIADO COM SUCESSO") }
                        .addOnFailureListener { exception ->
                            exception.let {
                                Log.e("USER", it.localizedMessage)
                            }
                        }
                }
           // }
        }
    }

//    private fun fullCheck() {
//        require(displayName.value.toString() != "") {}
//
//
//    }


}