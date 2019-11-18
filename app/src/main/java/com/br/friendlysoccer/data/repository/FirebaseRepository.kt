package com.br.friendlysoccer.data.repository

import android.util.Log
import com.br.friendlysoccer.data.model.User
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class FirebaseRepository(private val mAuth: FirebaseAuth) {

    fun getUser() = mAuth.currentUser

    fun doSimpliedLogin(user: User): Task<AuthResult> {
        return mAuth.signInWithEmailAndPassword(user.email, user.pass)
            .addOnSuccessListener { teste -> Log.e("USER", "SUCESSO") }
            .addOnFailureListener { exception ->
                Log.e(
                    "USER",
                    "FALHA " + exception.localizedMessage
                )
            }
    }

    private fun profileUpdate(name: String) {
        val request = UserProfileChangeRequest.Builder()
            .setDisplayName(name)
            .build()
        getUser()?.updateProfile(request)?.addOnSuccessListener { success ->
            Log.e("USER", "alterado")
        }?.addOnFailureListener { failure ->
            Log.e("USER", "FAIL")
        }

    }

    fun makeNewUser(
        userDisplayName: String,
        userEmail: String,
        userPassword: String
    ): Task<AuthResult> {
        return mAuth.createUserWithEmailAndPassword(userEmail, userPassword)
            .addOnSuccessListener { profileUpdate(userDisplayName) }
            .addOnFailureListener { exception ->
                Log.e(
                    "USER",
                    "FALHA " + exception.localizedMessage
                )
            }
    }

    fun makeLogOut() {
        mAuth.signOut()
    }

    fun updateUser() {

    }


    @Override
    fun onAuthStateChanged(mAuth: FirebaseAuth) {
        val user1 = mAuth.currentUser

        if (user1 != null) {
            //usuario logado

        }
    }


    companion object {
        @Volatile
        private var instance: FirebaseRepository? = null

        fun getInstance(mAuth: FirebaseAuth) =
            instance
                ?: synchronized(this) {
                    instance
                        ?: FirebaseRepository(
                            mAuth
                        ).also { instance = it }
                }
    }

}