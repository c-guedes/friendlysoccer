package com.br.friendlysoccer.data.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.br.friendlysoccer.data.dao.FirebaseListener

abstract class FirebaseDatabase: RoomDatabase() {
    abstract val firebaseDatabaseDao: FirebaseListener

    companion object{
        @Volatile var INSTANCE: FirebaseDatabase? = null
        fun getInstance(context: Context): FirebaseDatabase{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FirebaseDatabase::class.java,
                        "soccer_database_table"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}