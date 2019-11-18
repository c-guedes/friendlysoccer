package com.br.friendlysoccer.data.dao

import androidx.room.Dao
import com.br.friendlysoccer.data.model.User

@Dao
interface FirebaseListener {
    fun getUser()

    fun doLogin(user: User)
}