package com.example.fitfusion.localdatabase

import TrainingDatabase
import com.example.fitfusion.localdatabase.usuarios.AppDatabase


import android.app.Application
import androidx.room.Room

class NotMyApp : Application() {
    companion object {
        lateinit var database: TrainingDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            TrainingDatabase::class.java,
            "my_app_database"
        ).build()
    }
}
